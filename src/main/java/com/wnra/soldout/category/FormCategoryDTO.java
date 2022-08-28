package com.wnra.soldout.category;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class FormCategoryDTO {

    @NotBlank(message = "O nome da categoria não pode ser nulo!")
    private String name;

}
