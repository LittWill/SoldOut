package com.wnra.soldout.product.shoes.dto;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wnra.soldout.domain.ProductModelMapper;
import com.wnra.soldout.domain.Shoes;
import com.wnra.soldout.product.ProductMapper;
import lombok.NonNull;
import lombok.SneakyThrows;

public class ModelShoesMapper implements ProductModelMapper {
    @SneakyThrows
    public Shoes toModel(@NonNull JsonNode jsonNode, ObjectMapper objectMapper, ProductMapper productMapper) {
        SaveShoesDTO saveShoesDTO = objectMapper.treeToValue(jsonNode, SaveShoesDTO.class);
        return productMapper.toModel(saveShoesDTO);
    }
}
