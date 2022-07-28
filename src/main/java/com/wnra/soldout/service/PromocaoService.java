package com.wnra.soldout.service;

import com.wnra.soldout.model.ItemCompra;
import com.wnra.soldout.model.Produto;
import com.wnra.soldout.model.Promocao;
import com.wnra.soldout.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PromocaoService extends GenericService<Promocao, String> {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void definirPromocao(List<Produto> produtos, Promocao promocao){
       if (promocao.getDataExpiracao().isBefore(LocalDateTime.now())){
           throw new RuntimeException("Essa promoção foi expirada!");
        }

       produtos.forEach(produto -> produto.setPromocao(promocao));

       produtoRepository.saveAll(produtos);
    }

    public void aplicarDescontoPromocao(List<ItemCompra> itensCompra) {
        itensCompra.forEach(itemCompra -> {
            boolean promocaoAtiva = itemCompra.getProduto().getPromocao() != null;

            if (promocaoAtiva) {
                Promocao promocao = itemCompra.getProduto().getPromocao();

                if (Boolean.TRUE.equals(promocao.getIsValorPorcentagem())) {
                    itemCompra.setValor(BigDecimal.valueOf(itemCompra.getValor().doubleValue() - (itemCompra.getValor().doubleValue() * promocao.getValor().doubleValue() / 100)));
                } else {
                    itemCompra.setValor(BigDecimal.valueOf(itemCompra.getValor().doubleValue() - promocao.getValor().doubleValue()));
                }
            }
        });
    }

}
