package com.wnra.soldout.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wnra.soldout.product.shoes.dto.ModelShoesMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum ProductType {

    SHOES(ProductConstants.SHOE_TYPE, new ModelShoesMapper());
    private final String type;
    private final ProductModelMapper modelMapperInstance;

    public static ProductType getByType(String type) {
        return Arrays.stream(ProductType.values())
                .filter(productType -> productType.getType().equals(type))
                .findAny()
                .orElseThrow();
    }
}
