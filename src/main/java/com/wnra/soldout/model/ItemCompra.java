package com.wnra.soldout.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    private Product product;

    @ManyToOne
    @JoinColumn(name = "tamanho_id", nullable = false)
    private Tamanho tamanho;

    @ManyToOne
    @JoinColumn(name = "promocao_utilizada_id")
    private Promocao promocaoUtilizada;

    public ItemCompra(Integer quantidade, BigDecimal valor, Product product, Tamanho tamanho) {
        this.id = UUID.randomUUID().toString();
        this.quantidade = quantidade;
        this.valor = valor;
        this.product = product;
        this.tamanho = tamanho;
    }

}
