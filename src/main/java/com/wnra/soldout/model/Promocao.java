package com.wnra.soldout.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Promocao {

    @Id
    @Column(updatable = false)
    private String id;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @Column(nullable = false)
    private LocalDateTime dataExpiracao;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private Boolean isValorPorcentagem;

    public Promocao(LocalDateTime dataExpiracao, BigDecimal valor, Boolean isValorPorcentagem) {
        this.id = UUID.randomUUID().toString();
        this.dataCriacao = LocalDateTime.now();
        this.dataExpiracao = dataExpiracao;
        this.valor = valor;
        this.isValorPorcentagem = isValorPorcentagem;
    }

    public Promocao(String id){
        this.id = id;
    }

}
