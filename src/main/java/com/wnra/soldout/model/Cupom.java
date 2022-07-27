package com.wnra.soldout.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

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
    private String codigo;
    private BigDecimal valor;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataCriacao;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataExpiracao;
    private Boolean isValorPorcentagem;
    private Boolean isFreteCupom;
    private BigDecimal valorMinimo;
    private BigDecimal valorMaximo;

    public Cupom (String codigo, BigDecimal valor, LocalDateTime dataExpiracao, Boolean isValorPorcentagem, Boolean isFreteCupom){
        this.id = UUID.randomUUID().toString();
        this.codigo = codigo;
        this.valor = valor;
        this.dataExpiracao = dataExpiracao;
        this.isValorPorcentagem = isValorPorcentagem;
        this.isFreteCupom = isFreteCupom;
        this.dataCriacao = LocalDateTime.now();
    }

    public Double converterValorParaPorcentagem(){
        return valor.doubleValue() / 100;
    }

}
