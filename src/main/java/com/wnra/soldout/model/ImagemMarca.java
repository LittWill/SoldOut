package com.wnra.soldout.model;

import lombok.*;

import javax.persistence.*;

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
