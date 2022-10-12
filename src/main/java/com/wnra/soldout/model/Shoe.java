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
public class Shoe extends Product {

    public Shoe(String descricao, String modelo, BigDecimal preco, Boolean compraUnica, Promotion promotion,
                Brand brand, List<Category> categories, List<Genre> genres, String color, List<Size> sizes) {
        super(descricao, modelo, preco, compraUnica, promotion, brand, categories, genres);
        this.sizes = sizes;
        this.color = color;
    }

    private String color;

    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Size> sizes;

}
