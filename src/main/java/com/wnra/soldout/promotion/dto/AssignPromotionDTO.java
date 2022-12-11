package com.wnra.soldout.promotion.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class AssignPromotionDTO {
    @NotBlank
    private String promotionId;
    @NotEmpty
    private List<String> productsIds;
}
