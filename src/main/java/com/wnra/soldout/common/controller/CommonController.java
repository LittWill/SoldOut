package com.wnra.soldout.common.controller;

import com.wnra.soldout.common.service.GenericService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class CommonController<T, ID, FormDTO> {

    private final GenericService<T, ID> genericService;

    @PostMapping
    public ResponseEntity<T> salvar(@RequestBody FormDTO formDTO){
        T t = this.converterFormDTO(formDTO);
        return ResponseEntity.ok(genericService.salvar(t));
    }

    @GetMapping("{id}")
    public ResponseEntity<T> obter(@PathVariable ID id){
        return ResponseEntity.ok(genericService.obter(id));
    }

    @GetMapping
    public ResponseEntity<Page<T>> listar(@PageableDefault Pageable pageable){
        return ResponseEntity.ok(genericService.listar(pageable));
    }

    protected abstract T converterFormDTO(FormDTO formDTO);


}
