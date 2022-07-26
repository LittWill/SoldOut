package com.wnra.soldout.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    private String id;
    private LocalDateTime dataAdicao;
    private String nome;

    @OneToMany(mappedBy = "marca")
    private List<ImagemMarca> imagensMarca;

    public Marca(String nome) {
        this.id = UUID.randomUUID().toString();
        this.dataAdicao = LocalDateTime.now();
        this.nome = nome;
    }

}
