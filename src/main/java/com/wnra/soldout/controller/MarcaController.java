package com.wnra.soldout.controller;
import com.wnra.soldout.dto.FormMarcaDTO;
import com.wnra.soldout.model.Marca;
import com.wnra.soldout.service.GenericService;
import com.wnra.soldout.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
