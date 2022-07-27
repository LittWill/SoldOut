package com.wnra.soldout.service;

import com.wnra.soldout.model.Compra;
import com.wnra.soldout.model.ItemCompra;
import com.wnra.soldout.model.ProdutoEstoque;
import com.wnra.soldout.repository.ProdutoEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoEstoqueService extends GenericService<ProdutoEstoque, String> {

    @Autowired
    private ProdutoEstoqueRepository produtoEstoqueRepository;

    public void verificarEstoque(List<ItemCompra> itensCompra){
        itensCompra.forEach(itemCompra -> {
            ProdutoEstoque produtoEstoque = this.obterPorProdutoId(itemCompra.getProduto().getId());
            if (produtoEstoque.getQuantidade() < itemCompra.getQuantidade()){
                throw new RuntimeException("Não há estoque disponível");
            }
        });
    }

    public ProdutoEstoque obterPorProdutoId(String produtoId){
        return produtoEstoqueRepository.findByProdutoId(produtoId).orElseThrow(() -> new RuntimeException("Estoque de produto não encontrado!"));
    }

    public void descontarEstoque(Compra compra){
        List<ItemCompra> itensCompra = compra.getItensCompra();
        List<ProdutoEstoque> produtosEstoque = new ArrayList<>();
        itensCompra.forEach(itemCompra -> {
            ProdutoEstoque produtoEstoque = this.obterPorProdutoId(itemCompra.getProduto().getId());
            produtoEstoque.setQuantidade(produtoEstoque.getQuantidade() - itemCompra.getQuantidade());
            produtosEstoque.add(produtoEstoque);
        });

        super.repository.saveAll(produtosEstoque);
    }
}
