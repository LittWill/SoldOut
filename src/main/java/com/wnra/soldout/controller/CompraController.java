package com.wnra.soldout.controller;

import com.wnra.soldout.dto.FormCompraDTO;
import com.wnra.soldout.mapper.ItemCompraMapper;
import com.wnra.soldout.model.*;
import com.wnra.soldout.service.*;
import com.wnra.soldout.utils.CupomUtils;
import com.wnra.soldout.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


        itensCompra.forEach(itemCompra -> itemCompra.setPromocaoUtilizada(itemCompra.getProduto().getPromocao()));

        Compra compra = new Compra(formCompraDTO.getValorFrete(), conta, endereco, null,
                itensCompra);


        if (formCompraDTO.getCupomCodigo() != null) {
            compra = CupomUtils.aplicarCupom(cupomService.obterPorCodigo(formCompraDTO.getCupomCodigo()), compra);
        }

        compra = compraService.salvar(compra);

        produtoEstoqueService.descontarEstoque(compra);

        return ResponseEntity.ok(compra.getId());
    }

    @GetMapping
    public ResponseEntity<Page<String>> listar(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(compraService.listar(pageable).map(compra -> String.valueOf(compra.getId())));
    }

    @GetMapping("{id}")
    public ResponseEntity<String> obter(@PathVariable String id) {
        return ResponseEntity.ok(compraService.obter(id).getId());
    }

    private List<ItemCompra> extrairItensCompra(FormCompraDTO formCompraDTO, ProdutoService produtoService) {
        return formCompraDTO.getItensCompraDTO().stream().map(formItemCompraDTO -> ItemCompraMapper.formDTOToEntity(formItemCompraDTO, produtoService)).collect(Collectors.toList());
    }

    private List<Promocao> extrairPromocoes(List<ItemCompra> itensCompra) {
        boolean algumaPromocaoExpirada = false;
        for (var itemCompra : itensCompra) {
            Promocao promocao = itemCompra.getProduto().getPromocao();
            if (promocao != null && DateUtils.isDataExpirada(promocao.getDataExpiracao())) {
                algumaPromocaoExpirada = true;
                promocaoService.expirarPromocao(promocao);
            }
        }

        if (algumaPromocaoExpirada) {
            throw new RuntimeException("Não foi possível concluir a compra! Uma ou mais promoções estão expiradas! " +
                    "Tente novamente!");
        }
        return itensCompra.stream().map(itemCompra -> itemCompra.getProduto().getPromocao()).collect(Collectors.toList());
    }

}
