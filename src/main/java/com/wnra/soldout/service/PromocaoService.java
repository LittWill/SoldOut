package com.wnra.soldout.service;

import com.wnra.soldout.model.Produto;
import com.wnra.soldout.model.Promocao;
import com.wnra.soldout.repository.ProdutoRepository;
import com.wnra.soldout.repository.PromocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PromocaoService extends GenericService<Promocao, String> {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PromocaoRepository promocaoRepository;

    public Promocao expirarPromocao(Promocao promocao){
        promocao.setDataExpiracao(LocalDateTime.now());
        produtoRepository.findByPromocao(promocao).forEach(produto -> produto.setPromocao(null));
        return super.salvar(promocao);
    }

    public void definirPromocao(List<Produto> produtos, Promocao promocao){
       if (promocao.getDataExpiracao().isBefore(LocalDateTime.now())){
           throw new RuntimeException("Essa promoção foi expirada!");
        }

       produtos.forEach(produto -> produto.setPromocao(promocao));

       produtoRepository.saveAll(produtos);
    }


}
