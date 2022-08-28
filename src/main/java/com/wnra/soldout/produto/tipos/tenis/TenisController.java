package com.wnra.soldout.produto.tipos.tenis;

import com.wnra.soldout.produto.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tenis")
@RequiredArgsConstructor
public class TenisController {

    private final ProdutoService produtoService;



}
