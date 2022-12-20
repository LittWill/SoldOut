package com.wnra.soldout.templates;

import com.wnra.soldout.domain.Brand;
import com.wnra.soldout.domain.Category;
import com.wnra.soldout.domain.Product;
import com.wnra.soldout.domain.Shoes;

import java.math.BigDecimal;
import java.util.List;

public class ProductTemplate {

    public static Shoes getValid(Brand brand, Category category) {
        return Shoes.builder()
                .model("PRODUCT_MODEL")
                .description("PRODUCT_DESCRIPTION")
                .price(BigDecimal.valueOf(500))
                .brand(brand)
                .type("PRODUCT_TYPE")
                .categories(List.of(category))
                .build();
    }
}
