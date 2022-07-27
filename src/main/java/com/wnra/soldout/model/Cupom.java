package com.wnra.soldout.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Cupom {

    @Id
    private String id;

    @Column(length = 50, unique = true, updatable = false, nullable = false)
    private String codigo;

    @Column(nullable = false)
    private BigDecimal valor;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataExpiracao;

    @Column(nullable = false)
    private Boolean isValorPorcentagem;

    @Column(nullable = false)
    private Boolean isFreteCupom;

    private BigDecimal valorMinimo;
    private BigDecimal valorMaximo;

    public Cupom(String codigo, BigDecimal valor, LocalDateTime dataExpiracao, Boolean isValorPorcentagem,
                 Boolean isFreteCupom) {
        this.id = UUID.randomUUID().toString();
        this.codigo = codigo;
        this.valor = valor;
        this.dataExpiracao = dataExpiracao;
        this.isValorPorcentagem = isValorPorcentagem;
        this.isFreteCupom = isFreteCupom;
        this.dataCriacao = LocalDateTime.now();
    }

    public Double converterValorParaPorcentagem() {
        return valor.doubleValue() / 100;
    }

}
