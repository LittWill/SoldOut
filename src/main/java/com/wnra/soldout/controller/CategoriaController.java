package com.wnra.soldout.controller;

import com.wnra.soldout.dto.FormCategoriaDTO;
import com.wnra.soldout.model.Categoria;
import com.wnra.soldout.service.CategoriaService;
import com.wnra.soldout.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categorias")
public class CategoriaController extends CommonController<Categoria, String, FormCategoriaDTO> {

    @Autowired
    private CategoriaService categoriaService;

    protected CategoriaController(GenericService<Categoria, String> genericService) {
        super(genericService);
    }

    @Override
    protected Categoria converterFormDTO(FormCategoriaDTO formCategoriaDTO) {
        return new Categoria(formCategoriaDTO.getNome());
    }

}
