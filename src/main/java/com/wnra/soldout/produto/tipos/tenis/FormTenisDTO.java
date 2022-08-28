package com.wnra.soldout.produto.tipos.tenis;

import com.wnra.soldout.produto.FormProdutoDTO;
import com.wnra.soldout.produto.tipos.tenis.tamanho.FormTamanhoDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class FormTenisDTO extends FormProdutoDTO {

    private String cor;

    private List<FormTamanhoDTO> tamanhos;
}
