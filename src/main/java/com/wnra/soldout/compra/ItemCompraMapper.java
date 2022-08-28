package com.wnra.soldout.compra;

import com.wnra.soldout.model.ItemCompra;
import com.wnra.soldout.model.Product;
import com.wnra.soldout.model.Tamanho;
import com.wnra.soldout.produto.ProdutoService;

import java.math.BigDecimal;

public class ItemCompraMapper {

    private ItemCompraMapper() {
        throw new IllegalStateException("Utility class");
    }

    
    public static ItemCompra formDTOToEntity(FormItemCompraDTO dto, ProdutoService produtoService){
        Product product = produtoService.get(dto.getProdutoId());
        BigDecimal preco = product.getPrice();
        return new ItemCompra(dto.getQuantidade(), preco, product, new Tamanho(dto.getTamanhoId()));
    }
            
            
}
