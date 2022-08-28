package com.wnra.soldout.promocao;

import com.wnra.soldout.common.service.GenericService;
import com.wnra.soldout.model.ItemCompra;
import com.wnra.soldout.model.Produto;
import com.wnra.soldout.model.Promocao;
import com.wnra.soldout.produto.ProdutoRepository;
import com.wnra.soldout.utils.DateUtils;
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

    public Promocao expirarPromocao(Promocao promocao) {
        promocao.setDataExpiracao(LocalDateTime.now());
        produtoRepository.findByPromocao(promocao).forEach(produto -> produto.setPromocao(null));
        return super.save(promocao);
    }

    public void definirPromocao(List<Produto> produtos, Promocao promocao) {
        if (promocao.getDataExpiracao().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Essa promoção foi expirada!");
        }

        produtos.forEach(produto -> produto.setPromocao(promocao));

        produtoRepository.saveAll(produtos);
    }

    public void verificarPromocaoExpirada(List<ItemCompra> itensCompra) {
        itensCompra.forEach(itemCompra -> {
            if (itemCompra.getProduto().getPromocao() != null && DateUtils.isDataExpirada(itemCompra.getProduto().getPromocao().getDataExpiracao())) {
                throw new RuntimeException("Uma ou mais promoções estão expiradas! Tente novamente!");
            }
        });

    }

}
