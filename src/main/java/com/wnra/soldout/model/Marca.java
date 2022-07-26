package com.wnra.soldout.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "marcas")
public class Marca {

    @Id
    private String id;
    private LocalDateTime dataAdicao;
    private String nome;

    public Marca(String nome) {
        this.id = UUID.randomUUID().toString();
        this.dataAdicao = LocalDateTime.now();
        this.nome = nome;
    }

}
