package com.wnra.soldout.service;

import com.wnra.soldout.model.ItemCompra;
import com.wnra.soldout.model.Promocao;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PromocaoService extends GenericService<Promocao, String> {

    public void aplicarPromocao(List<ItemCompra> itensCompra) {
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
