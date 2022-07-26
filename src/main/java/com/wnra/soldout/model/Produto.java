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
    private String id;
    private LocalDateTime dataAdicao;
    private String descricao;
    private String modelo;
    private BigDecimal preco;
    private Boolean compraUnica;
    @ManyToOne
    @JoinColumn(name = "promocao_id")
    private Promocao promocao;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    @ManyToMany
    private List<Categoria> categorias;

    @ManyToMany
    private List<Genero> generos;

    @OneToMany
    private List<ImagemProduto> imagens;

}
