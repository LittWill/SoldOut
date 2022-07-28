package com.wnra.soldout.utils;

import com.wnra.soldout.model.ItemCompra;
import com.wnra.soldout.model.Promocao;

import java.math.BigDecimal;
import java.util.List;

public class PromocaoUtils {

    public static List<ItemCompra> aplicarDescontoPromocao(List<ItemCompra> itensCompra) {
        itensCompra.forEach(itemCompra -> {
            boolean promocaoAtiva = itemCompra.getProduto().getPromocao() != null && !DateUtils.isDataExpirada(itemCompra.getProduto().getPromocao().getDataExpiracao());

            if (promocaoAtiva) {
                Promocao promocao = itemCompra.getProduto().getPromocao();

                if (Boolean.TRUE.equals(promocao.getIsValorPorcentagem())) {
                    itemCompra.setValor(BigDecimal.valueOf(itemCompra.getValor().doubleValue() - (itemCompra.getValor().doubleValue() * promocao.getValor().doubleValue() / 100)));
                } else {
                    itemCompra.setValor(BigDecimal.valueOf(itemCompra.getValor().doubleValue() - promocao.getValor().doubleValue()));
                }
            }
        });

        return itensCompra;
    }

    public static BigDecimal descontarValorPromocao(Promocao promocao, BigDecimal valor){
        if (Boolean.TRUE.equals(promocao.getIsValorPorcentagem())){
            return BigDecimal.valueOf(valor.doubleValue() - (valor.doubleValue() * CalculosUtils.converterValorParaPorcentagem(promocao.getValor())));
        }

        return BigDecimal.valueOf(valor.doubleValue() - promocao.getValor().doubleValue());
    }
}
