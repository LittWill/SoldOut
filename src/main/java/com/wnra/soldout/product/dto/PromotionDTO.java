package com.wnra.soldout.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.wnra.soldout.domain.Promotion} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromotionDTO {
    private String id;
    private LocalDateTime creationDate;
    private BigDecimal value;
    private Boolean isPercentageValue;
}