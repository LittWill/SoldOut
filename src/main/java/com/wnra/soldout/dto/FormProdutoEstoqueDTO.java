package com.wnra.soldout.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wnra.soldout.model.Produto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class FormProdutoEstoqueDTO {

    private String produtoId;
    private Integer quantidade;

}
