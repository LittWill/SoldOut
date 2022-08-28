package com.wnra.soldout.cupom;

import com.wnra.soldout.common.controller.CommonController;
import com.wnra.soldout.common.service.GenericService;
import com.wnra.soldout.model.Cupom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.wnra.soldout.cupom.CupomMapper.formUpdateCupomDTOToEntity;
@RestController
@RequestMapping("cupons")
public class CupomController extends CommonController<Cupom, String, FormCupomDTO> {

    @Autowired
    private CupomService cupomService;

    protected CupomController(GenericService<Cupom, String> genericService) {
        super(genericService);
    }

    @GetMapping("codigo/{codigo}")
    public ResponseEntity<?> obterPorCodigo(@PathVariable String codigo){
        return ResponseEntity.ok(cupomService.obterPorCodigo(codigo));
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
