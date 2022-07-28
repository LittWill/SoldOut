package com.wnra.soldout.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class FormCompraDTO {

    private BigDecimal valorFrete;
    private String contaId;
    private String enderecoId;
    private String cupomCodigo;
    private List<FormItemCompraDTO> itensCompraDTO;

}
