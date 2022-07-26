package com.wnra.soldout.controller;

import com.wnra.soldout.dto.FormCategoriaDTO;
import com.wnra.soldout.model.Categoria;
import com.wnra.soldout.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("categorias")
@RequiredArgsConstructor
public class CategoriaController {

    @Autowired
    private final CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<?> salvarCategoria(@RequestBody FormCategoriaDTO categoriaDTO){
        Categoria categoriaSalva = this.categoriaService.salvar(new Categoria(categoriaDTO.getNome(), LocalDateTime.now()));
        return ResponseEntity.ok(categoriaSalva);
    }


}
