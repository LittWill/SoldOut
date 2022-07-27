package com.wnra.soldout.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Genero {

    @Id
    @Column(updatable = false)
    private String nome;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataAdicao;

    public Genero(String nome) {
        this.nome = nome;
        this.dataAdicao = LocalDateTime.now();
    }

}
