package com.wnra.soldout.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ValorProdutosCarrinhoDTO {

    private BigDecimal valorFrete;
    private BigDecimal valorProdutos;

}
