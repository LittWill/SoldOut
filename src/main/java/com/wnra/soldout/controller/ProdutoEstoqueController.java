package com.wnra.soldout.controller;

import com.wnra.soldout.dto.FormProdutoEstoqueDTO;
import com.wnra.soldout.model.Produto;
import com.wnra.soldout.model.ProdutoEstoque;
import com.wnra.soldout.service.GenericService;
import com.wnra.soldout.service.ProdutoEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produtos/estoque")
public class ProdutoEstoqueController extends CommonController<ProdutoEstoque, String, FormProdutoEstoqueDTO> {

    @Autowired
    private ProdutoEstoqueService produtoEstoqueService;

    protected ProdutoEstoqueController(GenericService<ProdutoEstoque, String> genericService) {
        super(genericService);
    }

    @Override
    protected ProdutoEstoque converterFormDTO(FormProdutoEstoqueDTO formProdutoEstoqueDTO) {
        Produto produto = new Produto();
        produto.setId(formProdutoEstoqueDTO.getProdutoId());
        return new ProdutoEstoque(produto, formProdutoEstoqueDTO.getQuantidade());
    }

}
