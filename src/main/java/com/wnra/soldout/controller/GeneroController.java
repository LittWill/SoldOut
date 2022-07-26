package com.wnra.soldout.controller;

import com.wnra.soldout.dto.FormGeneroDTO;
import com.wnra.soldout.model.Genero;
import com.wnra.soldout.service.GenericService;
import com.wnra.soldout.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("generos")
public class GeneroController extends CommonController<Genero, String, FormGeneroDTO> {

    @Autowired
    private GeneroService generoService;

    protected GeneroController(GenericService<Genero, String> genericService) {
        super(genericService);
    }

    @Override
    protected Genero converterFormDTO(FormGeneroDTO formGeneroDTO) {
        return new Genero(formGeneroDTO.getNome());
    }

}
