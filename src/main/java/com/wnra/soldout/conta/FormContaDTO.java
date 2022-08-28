package com.wnra.soldout.conta;

import com.wnra.soldout.model.Cliente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormContaDTO {

    private Cliente cliente;
    private String senha;

}
