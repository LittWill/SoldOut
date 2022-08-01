package com.wnra.soldout.mapper;

import com.wnra.soldout.dto.FormCategoriaDTO;
import com.wnra.soldout.dto.FormGeneroDTO;
import com.wnra.soldout.dto.FormTenisDTO;
import com.wnra.soldout.model.*;
import com.wnra.soldout.service.CategoriaService;
import com.wnra.soldout.service.GeneroService;
import com.wnra.soldout.service.MarcaService;
import com.wnra.soldout.service.PromocaoService;

import java.util.List;
import java.util.stream.Collectors;

public class TenisMapper {

    public static Tenis formDTOToEntity(FormTenisDTO dto, PromocaoService promocaoService, MarcaService marcaService, CategoriaService categoriaService, GeneroService generoService){
        //Promocao promocao = promocaoService.obter(dto.getPromocaoId());
        Marca marca = marcaService.obter(dto.getMarcaId());

        List<String> idsCategorias = dto.getCategorias().stream().map(FormCategoriaDTO::getNome).collect(Collectors.toList());
        List<Categoria> categorias = categoriaService.obterTodosPorId(idsCategorias);

        List<String> idsGeneros = dto.getGeneros().stream().map(FormGeneroDTO::getNome).collect(Collectors.toList());
        List<Genero> generos = generoService.obterTodosPorId(idsGeneros);

        List<Tamanho> tamanhos = TamanhoMapper.formsDTOToEntity(dto.getTamanhos());

        return new Tenis(dto.getDescricao(), dto.getModelo(), dto.getPreco(), dto.getCompraUnica(), null, marca, categorias, generos, dto.getCor(), tamanhos);
    }
}
