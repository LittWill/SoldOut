package com.wnra.soldout.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class ImagemMarca extends Imagem{

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

}
