package com.wnra.soldout.promotion.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * A DTO for the {@link com.wnra.soldout.domain.Promotion} entity
 */
@Data
public class ResponsePromotionDTO  {
    private String id;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
    private BigDecimal value;
    private Boolean isPercentageValue;
    private List<ResponsePromotionProductDTO> products;
}