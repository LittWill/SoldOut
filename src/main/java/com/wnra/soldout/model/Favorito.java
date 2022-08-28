package com.wnra.soldout.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Favorito {

    @Id
    @Column(updatable = false)
    private String id;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataAdicao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "produto_id", updatable = false, unique = true)
    private Product product;

    @ManyToOne(optional = false)
    @JoinColumn(name = "conta_id", updatable = false, nullable = false)
    @JsonIgnore
    private Conta conta;

    public Favorito(Product product, Conta conta) {
        this.id = UUID.randomUUID().toString();
        this.dataAdicao = LocalDateTime.now();
        this.product = product;
        this.conta = conta;
    }

}
