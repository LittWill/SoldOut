package com.wnra.soldout.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class FormItemCompraDTO {

    private Integer quantidade;

    private BigDecimal valor;

    private String produtoId;

}
