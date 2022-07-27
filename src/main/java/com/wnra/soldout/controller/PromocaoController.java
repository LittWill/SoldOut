package com.wnra.soldout.controller;

import com.wnra.soldout.dto.FormPromocaoDTO;
import com.wnra.soldout.model.Promocao;
import com.wnra.soldout.service.GenericService;
import com.wnra.soldout.service.PromocaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("promocoes")
public class PromocaoController extends CommonController<Promocao, String, FormPromocaoDTO> {

    @Autowired
    private PromocaoService promocaoService;

    protected PromocaoController(GenericService<Promocao, String> genericService) {
        super(genericService);
    }

    @Override
    protected Promocao converterFormDTO(FormPromocaoDTO formPromocaoDTO) {
        return new Promocao(formPromocaoDTO.getDataExpiracao(), formPromocaoDTO.getValor(), formPromocaoDTO.getIsValorPorcentagem());
    }

}
