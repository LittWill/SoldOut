package com.wnra.soldout.controller;

import com.wnra.soldout.dto.FormContaDTO;
import com.wnra.soldout.model.Conta;
import com.wnra.soldout.service.ContaService;
import com.wnra.soldout.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contas")
public class ContaController extends CommonController<Conta, String, FormContaDTO> {

    @Autowired
    private ContaService contaService;

    protected ContaController(GenericService<Conta, String> genericService) {
        super(genericService);
    }

    @Override
    protected Conta converterFormDTO(FormContaDTO formContaDTO) {
        return new Conta(formContaDTO.getCliente(), formContaDTO.getSenha());
    }

}
