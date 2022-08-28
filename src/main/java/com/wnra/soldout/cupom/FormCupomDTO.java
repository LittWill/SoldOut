package com.wnra.soldout.cupom;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class FormCupomDTO {

    private String codigo;
    private BigDecimal valor;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataExpiracao;
    private Boolean isValorPorcentagem;
    private Boolean isFreteCupom;

}
