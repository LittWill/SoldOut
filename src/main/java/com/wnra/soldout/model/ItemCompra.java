package com.wnra.soldout.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class ItemCompra {

    @Id
    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private BigDecimal valor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "produto_id", updatable = false)
    private Produto produto;

    public ItemCompra(Integer quantidade, BigDecimal valor, Produto produto) {
        this.quantidade = quantidade;
        this.valor = valor;
        this.produto = produto;
    }

}
