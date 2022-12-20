package com.wnra.soldout.promotion.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SavePromotionDTO {
    @NotNull
    @Positive
    private BigDecimal value;
    @NotNull
    private Boolean isPercentageValue;
    @NotEmpty
    private List<String> productsIds;
    @NotBlank
    private String type;
}
