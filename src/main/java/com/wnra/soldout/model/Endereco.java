package com.wnra.soldout.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Endereco {

    @Id
    @Column(updatable = false)
    private String cep;

    @Column(nullable = false, updatable = false)
    private String nome;

    @Column(nullable = false, updatable = false)
    private String numero;

    @ManyToOne(optional = false)
    @JoinColumn(name = "conta_id", updatable = false)
    private Conta conta;
}
