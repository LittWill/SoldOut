package com.wnra.soldout.produto;

import com.wnra.soldout.categoria.FormCategoryDTO;
import com.wnra.soldout.genero.FormGeneroDTO;
import com.wnra.soldout.produto.tipos.tenis.tamanho.FormTamanhoDTO;
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
    private List<FormCategoryDTO> categorias;
    private List<FormGeneroDTO> generos;
    private List<FormTamanhoDTO> tamanhos;

}
