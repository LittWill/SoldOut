package com.wnra.soldout.genero;

import com.wnra.soldout.common.controller.CommonController;
import com.wnra.soldout.common.service.GenericService;
import com.wnra.soldout.model.Genero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("genres")
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
