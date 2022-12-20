package com.wnra.soldout.domain;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wnra.soldout.product.ProductMapper;

public interface ProductModelMapper {
    Product toModel(JsonNode jsonNode, ObjectMapper objectMapper, ProductMapper productMapper);
}
