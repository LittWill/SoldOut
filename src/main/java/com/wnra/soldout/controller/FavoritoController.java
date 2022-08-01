package com.wnra.soldout.controller;

import com.wnra.soldout.dto.FormFavoritoDTO;
import com.wnra.soldout.model.Favorito;
import com.wnra.soldout.service.FavoritoService;
import com.wnra.soldout.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("favoritos")
public class FavoritoController extends CommonController<Favorito, String, FormFavoritoDTO> {

    @Autowired
    private FavoritoService favoritoService;

    protected FavoritoController(GenericService<Favorito, String> genericService) {
        super(genericService);
    }

    @Override
    protected Favorito converterFormDTO(FormFavoritoDTO formFavoritoDTO) {
        return null;
    }

}
