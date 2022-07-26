package com.wnra.soldout.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Cupom {

    @Id
    private String codigo;
    private BigDecimal valor;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataExpiracao;
    private Boolean isValorPorcentagem;

}
