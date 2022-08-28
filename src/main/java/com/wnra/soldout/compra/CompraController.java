package com.wnra.soldout.compra;

import com.wnra.soldout.cupom.CupomService;
import com.wnra.soldout.model.Compra;
import com.wnra.soldout.model.Conta;
import com.wnra.soldout.model.Endereco;
import com.wnra.soldout.model.ItemCompra;
import com.wnra.soldout.produto.ProdutoService;
import com.wnra.soldout.produto.estoque.ProdutoEstoqueService;
import com.wnra.soldout.promocao.PromocaoService;
import com.wnra.soldout.utils.CupomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private PromocaoService promocaoService;

    @Autowired
    private ProdutoEstoqueService produtoEstoqueService;

    @Autowired
    private CupomService cupomService;

    @PostMapping
    public ResponseEntity<String> salvar(@RequestBody FormCompraDTO formCompraDTO) {
        List<ItemCompra> itensCompra = extrairItensCompra(formCompraDTO, produtoService);

        promocaoService.verificarPromocaoExpirada(itensCompra);

        produtoEstoqueService.verificarViolacaoCompraExclusiva(itensCompra);

        produtoEstoqueService.verificarDisponibilidadeEstoque(itensCompra);

        Conta conta = new Conta();
        conta.setId("3d8b334b-ebf8-4ec9-9ab8-7a97a16f9144");
        Endereco endereco = new Endereco();
        endereco.setId(formCompraDTO.getEnderecoId());


        itensCompra.forEach(itemCompra -> itemCompra.setPromocaoUtilizada(itemCompra.getProduct().getPromotion()));

        Compra compra = new Compra(formCompraDTO.getValorFrete(), conta, endereco, null,
                itensCompra);


        if (formCompraDTO.getCupomCodigo() != null) {
            CupomUtils.aplicarCupom(cupomService.obterPorCodigo(formCompraDTO.getCupomCodigo()), compra);
        }

        compra = compraService.save(compra);

        produtoEstoqueService.descontarEstoque(compra);

        return ResponseEntity.ok(compra.getId());
    }

    @GetMapping
    public ResponseEntity<Page<String>> listar(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(compraService.findAll(pageable).map(compra -> String.valueOf(compra.getId())));
    }

    @GetMapping("{id}")
    public ResponseEntity<String> obter(@PathVariable String id) {
        return ResponseEntity.ok(compraService.get(id).getId());
    }

    private List<ItemCompra> extrairItensCompra(FormCompraDTO formCompraDTO, ProdutoService produtoService) {
        return formCompraDTO.getItensCompraDTO().stream().map(formItemCompraDTO -> ItemCompraMapper.formDTOToEntity(formItemCompraDTO, produtoService)).collect(Collectors.toList());
    }
}
