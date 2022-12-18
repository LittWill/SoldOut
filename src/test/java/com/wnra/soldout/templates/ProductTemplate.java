package com.wnra.soldout.templates;

import com.wnra.soldout.domain.Brand;
import com.wnra.soldout.domain.Category;
import com.wnra.soldout.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public class ProductTemplate {

    public static Product getValid(Brand brand, Category category) {
        return Product.builder()
                .model("PRODUCT_MODEL")
                .description("PRODUCT_DESCRIPTION")
                .price(BigDecimal.valueOf(500))
                .brand(brand)
                .categories(List.of(category))
                .build();
    }
}
