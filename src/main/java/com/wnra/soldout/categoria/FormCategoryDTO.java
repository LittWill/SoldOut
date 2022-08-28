package com.wnra.soldout.categoria;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class FormCategoryDTO {

    @NotBlank(message = "O nome da categoria não pode ser nulo!")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
