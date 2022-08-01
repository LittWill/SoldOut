package com.wnra.soldout.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class FormTenisDTO extends FormProdutoDTO{

    private String cor;

    private List<FormTamanhoDTO> tamanhos;
}
