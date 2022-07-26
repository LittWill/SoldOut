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
public class ImagemProduto extends Imagem{

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

}
