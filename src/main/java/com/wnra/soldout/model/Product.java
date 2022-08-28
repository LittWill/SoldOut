package com.wnra.soldout.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Product {

    @Id
    @Column(updatable = false)
    private String id;

    @Column(nullable = false, updatable = false)
    private LocalDateTime addDate;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Boolean uniqueBuy;

    @ManyToOne
    @JoinColumn(name = "promotion_id")
    private Promocao promotion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "brand_id", updatable = false)
    private Marca brand;

    @ManyToMany
    private List<Category> categories;

    @ManyToMany
    private List<Genero> genres;

    @OneToMany(mappedBy = "product")
    private List<ImagemProduto> images;

    public Product(String description, String model, BigDecimal price, Boolean uniqueBuy, Promocao promotion,
                   Marca brand, List<Category> categories, List<Genero> genres) {
        this.id = UUID.randomUUID().toString();
        this.addDate = LocalDateTime.now();
        this.description = description;
        this.model = model;
        this.price = price;
        this.uniqueBuy = uniqueBuy;
        this.promotion = promotion;
        this.brand = brand;
        this.categories = categories;
        this.genres = genres;
    }

    public Product(String id) {
        this.id = id;
    }

}
