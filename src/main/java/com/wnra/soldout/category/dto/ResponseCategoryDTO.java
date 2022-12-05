package com.wnra.soldout.category.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class ResponseCategoryDTO {
    private String id;
    private LocalDateTime additionDate;
    private String name;
    private String description;
}
