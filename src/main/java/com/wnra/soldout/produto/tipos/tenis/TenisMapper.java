package com.wnra.soldout.produto.tipos.tenis;

import com.wnra.soldout.category.CategoryService;
import com.wnra.soldout.category.FormCategoryDTO;
import com.wnra.soldout.genero.FormGeneroDTO;
import com.wnra.soldout.genero.GeneroService;
import com.wnra.soldout.marca.MarcaService;
import com.wnra.soldout.model.Category;
import com.wnra.soldout.model.Genero;
import com.wnra.soldout.model.Marca;
import com.wnra.soldout.model.Tamanho;
import com.wnra.soldout.model.Tenis;
import com.wnra.soldout.produto.tipos.tenis.tamanho.TamanhoMapper;
import com.wnra.soldout.promocao.PromocaoService;

import java.util.List;
import java.util.stream.Collectors;

public class TenisMapper {

    public static Tenis formDTOToEntity(FormTenisDTO dto, PromocaoService promocaoService, MarcaService marcaService, CategoryService categoryService, GeneroService generoService){
        //Promocao promocao = promocaoService.obter(dto.getPromocaoId());
        Marca marca = marcaService.get(dto.getMarcaId());

        List<String> idsCategorias = dto.getCategorias().stream().map(FormCategoryDTO::getName).collect(Collectors.toList());
        List<Category> categories = categoryService.obterTodosPorId(idsCategorias);

        List<String> idsGeneros = dto.getGeneros().stream().map(FormGeneroDTO::getNome).collect(Collectors.toList());
        List<Genero> generos = generoService.obterTodosPorId(idsGeneros);

        List<Tamanho> tamanhos = TamanhoMapper.formsDTOToEntity(dto.getTamanhos());

        return new Tenis(dto.getDescricao(), dto.getModelo(), dto.getPreco(), dto.getCompraUnica(), null, marca, categories, generos, dto.getCor(), tamanhos);
    }
}
