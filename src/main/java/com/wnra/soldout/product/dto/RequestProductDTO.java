package com.wnra.soldout.product.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class RequestProductDTO {
    @NotBlank
    private String model;
    @NotBlank
    private String description;
    @NotNull
    @Positive
    private BigDecimal price;
    @NotBlank
    private String brandId;
    @NotEmpty
    private List<String> categoriesIds;
}
