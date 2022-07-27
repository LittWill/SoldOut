package com.wnra.soldout.controller;

import com.wnra.soldout.dto.FormProdutoDTO;
import com.wnra.soldout.model.Categoria;
import com.wnra.soldout.model.Genero;
import com.wnra.soldout.model.Marca;
import com.wnra.soldout.model.Produto;
import com.wnra.soldout.service.CategoriaService;
import com.wnra.soldout.service.GenericService;
import com.wnra.soldout.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("produtos")
public class ProdutoController extends CommonController<Produto, String, FormProdutoDTO> {

    @Autowired
    private ProdutoService produtoService;

    protected ProdutoController(GenericService<Produto, String> genericService) {
        super(genericService);
    }

    @Override
    protected Produto converterFormDTO(FormProdutoDTO formProdutoDTO) {
        Marca marca = new Marca();
        marca.setId(formProdutoDTO.getMarcaId());
        List<Categoria> categorias =
                formProdutoDTO.getCategorias().stream().map(categoria -> new Categoria(categoria.getNome())).collect(Collectors.toList());
        List<Genero> generos =
                formProdutoDTO.getGeneros().stream().map(genero -> new Genero(genero.getNome())).collect(Collectors.toList());

        return new Produto(formProdutoDTO.getDescricao(), formProdutoDTO.getModelo(), formProdutoDTO.getPreco(),
                formProdutoDTO.getCompraUnica(), null, marca, categorias, generos);
    }

}
