package com.wnra.soldout.controller;

import com.wnra.soldout.dto.FormTenisDTO;
import com.wnra.soldout.mapper.TenisMapper;
import com.wnra.soldout.model.Tenis;
import com.wnra.soldout.model.TenisEstoque;
import com.wnra.soldout.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tenis")
public class TenisController {

    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private PromocaoService promocaoService;

    @Autowired
    private MarcaService marcaService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private GeneroService generoService;

    @Autowired
    private ProdutoEstoqueService produtoEstoqueService;

    @PostMapping
    public ResponseEntity<?> salvarTenis(@RequestBody FormTenisDTO dto) {
        Tenis tenis = (Tenis) produtoService.salvar(TenisMapper.formDTOToEntity(dto, promocaoService, marcaService,
                categoriaService, generoService));

        tenis.getTamanhos().forEach(tamanho -> {
                    produtoEstoqueService.salvar(new TenisEstoque(tenis, tamanho, 0));
                }
        );

        return ResponseEntity.ok(tenis);
    }

}
