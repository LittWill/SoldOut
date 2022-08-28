package com.wnra.soldout.marca;

import com.wnra.soldout.common.controller.CommonController;
import com.wnra.soldout.common.service.GenericService;
import com.wnra.soldout.model.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("marcas")
public class MarcaController extends CommonController<Marca, String, FormMarcaDTO> {

    @Autowired
    private MarcaService marcaService;

    protected MarcaController(GenericService<Marca, String> genericService) {
        super(genericService);
    }

    @PatchMapping("{marcaId}")
    public ResponseEntity<?> alterar(@PathVariable String marcaId, @RequestBody FormMarcaDTO formMarcaDTO){
        Marca marcaAlterada = marcaService.alterar(marcaId, converterFormDTO(formMarcaDTO));
        return ResponseEntity.ok(marcaAlterada);
    }

    @Override
    protected Marca converterFormDTO(FormMarcaDTO formMarcaDTO) {
        return new Marca(formMarcaDTO.getNome());
    }

}
