package com.wnra.soldout.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Tenis extends Produto{

    public Tenis(String descricao, String modelo, BigDecimal preco, Boolean compraUnica, Promocao promocao,
                 Marca marca, List<Category> categories, List<Genero> generos, String cor, List<Tamanho> tamanhos) {
        super(descricao, modelo, preco, compraUnica, promocao, marca, categories, generos);
        this.tamanhos = tamanhos;
        this.cor = cor;
    }

    private String cor;

    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Tamanho> tamanhos;

}
