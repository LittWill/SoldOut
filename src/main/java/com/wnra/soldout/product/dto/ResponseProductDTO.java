package com.wnra.soldout.product.dto;

import com.wnra.soldout.brand.dto.ResponseBrandDTO;
import com.wnra.soldout.category.dto.ResponseCategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * A DTO for the {@link com.wnra.soldout.domain.Product} entity
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseProductDTO {
    private String id;
    private LocalDateTime additionDate;
    private LocalDateTime lastUpdate;
    private String model;
    private String description;
    private BigDecimal price;
    private ResponseBrandDTO brand;
    private PromotionDTO currentPromotion;
    private List<ResponseCategoryDTO> categories;
}