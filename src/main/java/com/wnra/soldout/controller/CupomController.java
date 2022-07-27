package com.wnra.soldout.controller;

import com.wnra.soldout.dto.FormCupomDTO;
import com.wnra.soldout.dto.FormUpdateCupomDTO;
import com.wnra.soldout.dto.ValorProdutosCarrinhoDTO;
import com.wnra.soldout.model.Cupom;
import com.wnra.soldout.service.CupomService;
import com.wnra.soldout.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.wnra.soldout.mapper.CupomMapper.formUpdateCupomDTOToEntity;
@RestController
@RequestMapping("cupons")
public class CupomController extends CommonController<Cupom, String, FormCupomDTO> {

    @Autowired
    private CupomService cupomService;

    protected CupomController(GenericService<Cupom, String> genericService) {
        super(genericService);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> atualizar(@PathVariable String id, @RequestBody FormUpdateCupomDTO formUpdateCupomDTO){
        Cupom cupomAtualizado = cupomService.atualizar(id, formUpdateCupomDTOToEntity(formUpdateCupomDTO));
        return ResponseEntity.ok(cupomAtualizado);
    }

    @Override
    protected Cupom converterFormDTO(FormCupomDTO formCupomDTO) {
        return new Cupom(formCupomDTO.getCodigo(), formCupomDTO.getValor(), formCupomDTO.getDataExpiracao(), formCupomDTO.getIsValorPorcentagem(), formCupomDTO.getIsFreteCupom());
    }



}
