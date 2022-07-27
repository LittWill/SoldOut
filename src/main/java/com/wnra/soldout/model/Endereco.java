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

    public Endereco (){
        this.id = UUID.randomUUID().toString();
    }

    public Endereco(String cep, String nome, String numero) {
        this.id = UUID.randomUUID().toString();
        this.cep = cep;
        this.nome = nome;
        this.numero = numero;
    }

}
