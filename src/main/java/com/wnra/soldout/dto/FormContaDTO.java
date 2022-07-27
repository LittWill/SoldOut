package com.wnra.soldout.dto;

import com.wnra.soldout.model.Cliente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormContaDTO {

    private Cliente cliente;
    private String senha;

}
