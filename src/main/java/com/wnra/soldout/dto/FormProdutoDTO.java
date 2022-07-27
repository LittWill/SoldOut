package com.wnra.soldout.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class FormProdutoDTO {

    private Boolean compraUnica;
    private String descricao;
    private String modelo;
    private BigDecimal preco;
    private String marcaId;
    private String promocaoId;
    private List<FormCategoriaDTO> categorias;
    private List<FormGeneroDTO> generos;

}
