package com.wnra.soldout.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Produto {

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
    @JoinColumn(name = "promocao_id", updatable = false)
    private Promocao promocao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "marca_id", updatable = false)
    private Marca marca;

    @ManyToMany
    private List<Categoria> categorias;

    @ManyToMany
    private List<Genero> generos;

    @OneToMany(mappedBy = "produto")
    private List<ImagemProduto> imagens;

}
