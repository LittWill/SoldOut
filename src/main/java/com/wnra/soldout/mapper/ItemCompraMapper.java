package com.wnra.soldout.mapper;

import com.wnra.soldout.dto.FormItemCompraDTO;
import com.wnra.soldout.model.ItemCompra;
import com.wnra.soldout.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class ItemCompraMapper {

    private final static ModelMapper modelMapper = new ModelMapper();
    
    public static ItemCompra formDTOToEntity(FormItemCompraDTO formItemCompraDTO, ProdutoService produtoService){
        ItemCompra itemCompra = modelMapper.map(formItemCompraDTO, ItemCompra.class);
        itemCompra.setId(UUID.randomUUID().toString());
        itemCompra.setProduto(produtoService.obter(formItemCompraDTO.getProdutoId()));
        itemCompra.setValor(itemCompra.getProduto().getPreco());
        return itemCompra;
    }
            
            
}
