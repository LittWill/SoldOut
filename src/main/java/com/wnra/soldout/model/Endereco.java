package com.wnra.soldout.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Endereco {

    @Id
    private String cep;
    private String nome;
    private String numero;
    private Boolean isValorPorcentagem;
    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;
}
