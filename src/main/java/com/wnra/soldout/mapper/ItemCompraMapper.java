package com.wnra.soldout.mapper;

import com.wnra.soldout.dto.FormItemCompraDTO;
import com.wnra.soldout.model.ItemCompra;
import com.wnra.soldout.model.Produto;
import com.wnra.soldout.model.Tamanho;
import com.wnra.soldout.service.ProdutoService;

import java.math.BigDecimal;

public class ItemCompraMapper {

    private ItemCompraMapper() {
        throw new IllegalStateException("Utility class");
    }

    
    public static ItemCompra formDTOToEntity(FormItemCompraDTO dto, ProdutoService produtoService){
        Produto produto = produtoService.obter(dto.getProdutoId());
        BigDecimal preco = produto.getPreco();
        return new ItemCompra(dto.getQuantidade(), preco, produto, new Tamanho(dto.getTamanhoId()));
    }
            
            
}
