package com.wnra.soldout.produto;

import com.wnra.soldout.category.FormCategoryDTO;
import com.wnra.soldout.genero.FormGeneroDTO;
import com.wnra.soldout.produto.tipos.tenis.tamanho.FormTamanhoDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class FormProdutoDTO {

    private Boolean uniqueBuy;
    private String description;
    private String model;
    private BigDecimal price;
    private String brandId;
    private String promotionId;
    private List<FormCategoryDTO> categories;
    private List<FormGeneroDTO> genres;
    private List<FormTamanhoDTO> tamanhos;

}
