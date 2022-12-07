package com.wnra.soldout.category.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCategoryDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
}
