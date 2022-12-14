package com.wnra.soldout.templates;

import com.wnra.soldout.domain.Promotion;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class PromotionTemplate {

    public static Promotion getValid() {
        return Promotion.builder()
                .id(UUID.randomUUID().toString())
                .creationDate(LocalDateTime.now())
                .lastUpdate(LocalDateTime.now())
                .value(BigDecimal.TEN)
                .isPercentageValue(true)
                .products(List.of(ProductTemplate.getValid()))
                .build();
    }

}
