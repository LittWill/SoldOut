package com.wnra.soldout.produto.estoque;

import com.wnra.soldout.model.TenisEstoque;
import com.wnra.soldout.produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
