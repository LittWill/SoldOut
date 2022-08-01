package com.wnra.soldout.controller;

import com.wnra.soldout.dto.FormProdutoEstoqueDTO;
import com.wnra.soldout.model.TenisEstoque;
import com.wnra.soldout.service.ProdutoEstoqueService;
import com.wnra.soldout.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produtos/estoque")
public class ProdutoEstoqueController {

    @Autowired
    private ProdutoEstoqueService produtoEstoqueService;

    @Autowired
    private ProdutoService produtoService;

    @PatchMapping("{id}")
    public ResponseEntity<?> alterarQuantidade(@PathVariable String id, @RequestBody FormProdutoEstoqueDTO dto) {
        TenisEstoque estoque = produtoEstoqueService.alterarQuantidade(id, dto.getQuantidade());
        return ResponseEntity.ok(estoque);
    }

}
