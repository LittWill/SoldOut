package com.wnra.soldout.promotion.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.List;

@Data
public class SavePromotionDTO {
    @NotNull
    @Positive
    private BigDecimal value;
    @NotNull
    private Boolean isPercentageValue;
    @NotEmpty
    private List<String> productsIds;
}
