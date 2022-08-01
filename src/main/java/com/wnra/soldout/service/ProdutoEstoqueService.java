package com.wnra.soldout.service;

import com.wnra.soldout.model.Compra;
import com.wnra.soldout.model.ItemCompra;
import com.wnra.soldout.model.TenisEstoque;
import com.wnra.soldout.repository.ProdutoEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoEstoqueService extends GenericService<TenisEstoque, String> {

    @Autowired
    private ProdutoEstoqueRepository produtoEstoqueRepository;

    public void verificarViolacaoCompraExclusiva(List<ItemCompra> itensCompra){
        itensCompra.forEach(itemCompra -> {
            if (Boolean.TRUE.equals(itemCompra.getProduto().getCompraUnica()) && itemCompra.getQuantidade() > 1){
                throw new RuntimeException("Quantidade não permitida para um ou mais itens!");
            }
        });
    }

    public void verificarDisponibilidadeEstoque(List<ItemCompra> itensCompra){
        itensCompra.forEach(itemCompra -> {
            TenisEstoque produtoEstoque = this.obterPorProdutoId(itemCompra.getProduto().getId());
            if (produtoEstoque.getQuantidade() < itemCompra.getQuantidade()){
                throw new RuntimeException("Não há estoque disponível!");
            }
        });
    }

    public TenisEstoque obterPorProdutoId(String produtoId){
        return produtoEstoqueRepository.findByTenisId(produtoId).orElseThrow(() -> new RuntimeException("Estoque de produto não encontrado!"));
    }

    public void descontarEstoque(Compra compra){
        List<ItemCompra> itensCompra = compra.getItensCompra();
        List<TenisEstoque> produtosEstoque = new ArrayList<>();
        itensCompra.forEach(itemCompra -> {
            TenisEstoque produtoEstoque = this.obterPorProdutoId(itemCompra.getProduto().getId());
            produtoEstoque.setQuantidade(produtoEstoque.getQuantidade() - itemCompra.getQuantidade());
            produtosEstoque.add(produtoEstoque);
        });

        super.repository.saveAll(produtosEstoque);
    }

    public TenisEstoque alterarQuantidade(String id, Integer quantidade) {
        TenisEstoque estoque = super.obter(id);
        estoque.setQuantidade(quantidade);
        estoque = super.salvar(estoque);
        return estoque;
    }

}
