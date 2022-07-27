package com.wnra.soldout.dto;

import com.wnra.soldout.model.Cupom;
import com.wnra.soldout.model.Endereco;
import com.wnra.soldout.model.Promocao;
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
    private String cupomId;
    private List<String> promocoesUtilizadas;
    private List<FormItemCompraDTO> itensCompraDTO;

}
