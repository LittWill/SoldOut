package com.wnra.soldout.category.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Builder
@Getter
@Setter
public class RequestCategoryDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
}
