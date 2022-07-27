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
public class Categoria {

    @Id
    @Column(length = 50, updatable = false)
    private String nome;
    @Column(nullable = false, updatable = false)
    private LocalDateTime dataAdicao;

    public Categoria (String nome){
        this.nome = nome;
        this.dataAdicao = LocalDateTime.now();
    }

}
