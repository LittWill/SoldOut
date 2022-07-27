package com.wnra.soldout.controller;

import com.wnra.soldout.dto.FormCompraDTO;
import com.wnra.soldout.model.*;
import com.wnra.soldout.service.CompraService;
import com.wnra.soldout.service.GenericService;
import com.wnra.soldout.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("compras")
public class CompraController extends CommonController<Compra, String, FormCompraDTO> {

    @Autowired
    private CompraService compraService;

    @Autowired
    private ProdutoService produtoService;

    protected CompraController(GenericService<Compra, String> genericService) {
        super(genericService);
    }

    @Override
    public ResponseEntity<Compra> salvar(@RequestBody FormCompraDTO formCompraDTO) {
        Conta conta = new Conta();
        conta.setId("3d8b334b-ebf8-4ec9-9ab8-7a97a16f9144");
        Endereco endereco = new Endereco();
        endereco.setId(formCompraDTO.getEnderecoId());

        List<ItemCompra> itemCompras =
                formCompraDTO.getItensCompraDTO().stream().map(itemCompraDTO -> new ItemCompra(UUID.randomUUID().toString(), itemCompraDTO.getQuantidade(), itemCompraDTO.getValor(), produtoService.obter(itemCompraDTO.getProdutoId()))).collect(Collectors.toList());
        List<Promocao> promocoesUtilizadas = itemCompras.stream().map(itemCompra -> itemCompra.getProduto().getPromocao()).collect(Collectors.toList());
                Compra compra = new Compra(formCompraDTO.getValorFrete(), conta, endereco, null, promocoesUtilizadas, itemCompras);
        return ResponseEntity.ok(compraService.salvar(compra));
    }

    @Override
    protected Compra converterFormDTO(FormCompraDTO formCompraDTO) {
        return null;
    }

}
