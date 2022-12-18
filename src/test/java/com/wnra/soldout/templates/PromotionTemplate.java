package com.wnra.soldout.templates;

import com.wnra.soldout.domain.Brand;
import com.wnra.soldout.domain.Category;
import com.wnra.soldout.domain.Product;
import com.wnra.soldout.domain.Promotion;
import com.wnra.soldout.promotion.dto.SavePromotionDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class PromotionTemplate {

    public static Promotion getFull(Brand brand, Category category) {
        return Promotion.builder()
                .id(UUID.randomUUID().toString())
                .creationDate(LocalDateTime.now())
                .lastUpdate(LocalDateTime.now())
                .value(BigDecimal.TEN)
                .isPercentageValue(true)
                .products(List.of(ProductTemplate.getValid(brand, category)))
                .build();
    }

    public static Promotion getFull() {
        return Promotion.builder()
                .id(UUID.randomUUID().toString())
                .creationDate(LocalDateTime.now())
                .lastUpdate(LocalDateTime.now())
                .value(BigDecimal.TEN)
                .isPercentageValue(true)
                .build();
    }

    public static Promotion getNew(Product product) {
        return Promotion.builder()
                .value(BigDecimal.TEN)
                .isPercentageValue(true)
                .products(List.of(product))
                .build();
    }

    public static SavePromotionDTO getNewDTO(String productId) {
        return SavePromotionDTO.builder()
                .value(BigDecimal.TEN)
                .isPercentageValue(true)
                .productsIds(List.of(productId))
                .build();
    }

}
