package com.wnra.soldout.templates;

import com.wnra.soldout.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public class ProductTemplate {

    public static Product getValid() {
        return Product.builder()
                .model("PRODUCT_MODEL")
                .description("PRODUCT_DESCRIPTION")
                .price(BigDecimal.valueOf(500))
                .brand(BrandTemplate.getValid())
                .categories(List.of(CategoryTemplate.getValid()))
                .build();
    }
}
