package com.wnra.soldout.categoria;

import com.wnra.soldout.common.controller.CommonController;
import com.wnra.soldout.common.service.GenericService;
import com.wnra.soldout.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
