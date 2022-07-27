package com.wnra.soldout.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Endereco {

    @Id
    @Column(updatable = false)
    private String id;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false, updatable = false)
    private String nome;

    @Column(nullable = false, updatable = false)
    private String numero;

    @ManyToOne(optional = false)
    @JoinColumn(name = "conta_id", updatable = false)
    private Conta conta;

    public Endereco (){
        this.id = UUID.randomUUID().toString();
    }
}
