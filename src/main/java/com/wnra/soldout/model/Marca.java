package com.wnra.soldout.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "marcas")
public class Marca {

    @Id
    @Column(updatable = false)
    private String id;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataAdicao;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "marca")
    private List<ImagemMarca> imagensMarca;

    public Marca(String nome) {
        this.id = UUID.randomUUID().toString();
        this.dataAdicao = LocalDateTime.now();
        this.nome = nome;
    }

}
