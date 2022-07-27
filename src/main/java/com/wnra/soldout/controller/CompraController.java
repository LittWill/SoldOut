package com.wnra.soldout.controller;

import com.wnra.soldout.dto.FormCompraDTO;
import com.wnra.soldout.dto.FormItemCompraDTO;
import com.wnra.soldout.mapper.ItemCompraMapper;
import com.wnra.soldout.model.*;
import com.wnra.soldout.service.CompraService;
import com.wnra.soldout.service.GenericService;
import com.wnra.soldout.service.ProdutoService;
import com.wnra.soldout.service.PromocaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("compras")
public class CompraController extends CommonController<Compra, String, FormCompraDTO> {

    @Autowired
    private CompraService compraService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private PromocaoService promocaoService;

    protected CompraController(GenericService<Compra, String> genericService) {
        super(genericService);
    }

    @Override
    public ResponseEntity<Compra> salvar(@RequestBody FormCompraDTO formCompraDTO) {
        Conta conta = new Conta();
        conta.setId("3d8b334b-ebf8-4ec9-9ab8-7a97a16f9144");
        Endereco endereco = new Endereco();
        endereco.setId(formCompraDTO.getEnderecoId());

        List<ItemCompra> itensCompra = extrairItensCompra(formCompraDTO, produtoService);

        List<Promocao> promocoesUtilizadas = extrairPromocoes(itensCompra);

        promocaoService.aplicarPromocao(itensCompra);

        Compra compra = new Compra(formCompraDTO.getValorFrete(), conta, endereco, null, promocoesUtilizadas,
                itensCompra);

        compra = compraService.salvar(compra);

        return ResponseEntity.ok(compra);
    }

    private List<ItemCompra> extrairItensCompra(FormCompraDTO formCompraDTO, ProdutoService produtoService){
        return formCompraDTO.getItensCompraDTO().stream().map(formItemCompraDTO -> ItemCompraMapper.formDTOToEntity(formItemCompraDTO, produtoService)).collect(Collectors.toList());
    }

    private List<Promocao> extrairPromocoes(List<ItemCompra> itensCompra){
        return itensCompra.stream().map(itemCompra -> itemCompra.getProduto().getPromocao()).collect(Collectors.toList());
    }

    @Override
    protected Compra converterFormDTO(FormCompraDTO formCompraDTO) {
        return null;
    }

}
