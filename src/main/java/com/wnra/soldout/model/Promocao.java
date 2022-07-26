package com.wnra.soldout.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Promocao {

    @Id
    private String id;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataExpiracao;
    private BigDecimal valor;
    private Boolean isValorPorcentagem;


}
