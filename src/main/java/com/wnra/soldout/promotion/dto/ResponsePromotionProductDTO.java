package com.wnra.soldout.promotion.dto;

import com.wnra.soldout.brand.dto.ResponseBrandDTO;
import com.wnra.soldout.category.dto.ResponseCategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * A DTO for the {@link com.wnra.soldout.domain.Product} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePromotionProductDTO {
    private String id;
    private LocalDateTime additionDate;
    private LocalDateTime lastUpdate;
    private String model;
    private String description;
    private BigDecimal price;
    private ResponseBrandDTO brand;
    private List<ResponseCategoryDTO> categories;
}