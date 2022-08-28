package com.wnra.soldout.favorito;

import com.wnra.soldout.common.controller.CommonController;
import com.wnra.soldout.common.service.GenericService;
import com.wnra.soldout.model.Favorito;
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
