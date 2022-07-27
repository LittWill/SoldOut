package com.wnra.soldout.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente {

    @Column(nullable = false, updatable = false)
    private String primeiroNome;
    @Column(nullable = false, updatable = false)
    private String ultimoNome;
    @Column(nullable = false, updatable = false)
    private String email;
    @Column(nullable = false)
    private String telefone;

}
