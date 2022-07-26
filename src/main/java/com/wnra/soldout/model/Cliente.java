package com.wnra.soldout.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Cliente {
    private String primeiroNome;
    private String ultimoNome;
    private String email;
    private String telefone;
}
