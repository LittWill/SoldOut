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
public abstract class Produto {

    @Id
    @Column(updatable = false)
    private String id;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataAdicao;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private Boolean compraUnica;

    @ManyToOne
    @JoinColumn(name = "promocao_id")
    private Promocao promocao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "marca_id", updatable = false)
    private Marca marca;

    @ManyToMany
    private List<Category> categories;

    @ManyToMany
    private List<Genero> generos;

    @OneToMany(mappedBy = "produto")
    private List<ImagemProduto> imagens;

    public Produto(String descricao, String modelo, BigDecimal preco, Boolean compraUnica, Promocao promocao,
                   Marca marca, List<Category> categories, List<Genero> generos) {
        this.id = UUID.randomUUID().toString();
        this.dataAdicao = LocalDateTime.now();
        this.descricao = descricao;
        this.modelo = modelo;
        this.preco = preco;
        this.compraUnica = compraUnica;
        this.promocao = promocao;
        this.marca = marca;
        this.categories = categories;
        this.generos = generos;
    }

    public Produto(String id) {
        this.id = id;
    }

}
