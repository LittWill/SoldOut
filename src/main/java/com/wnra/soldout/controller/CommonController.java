package com.wnra.soldout.controller;

import com.wnra.soldout.service.GenericService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class CommonController<T, ID, FormDTO> {

    private final GenericService<T, ID> genericService;

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody FormDTO formDTO){
        T t = this.converterFormDTO(formDTO);
        return ResponseEntity.ok(genericService.salvar(t));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> excluir(@PathVariable ID id){
        genericService.excluir(id);
        return ResponseEntity.ok("O objeto foi excluído!");
    }

    @GetMapping("{id}")
    public ResponseEntity<?> obter(@PathVariable ID id){
        return ResponseEntity.ok(genericService.obter(id));
    }

    @GetMapping
    public ResponseEntity<?> listar(@PageableDefault Pageable pageable){
        return ResponseEntity.ok(genericService.listar(pageable));
    }

    protected abstract T converterFormDTO(FormDTO formDTO);


}
