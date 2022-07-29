package com.wnra.soldout.utils;

import com.wnra.soldout.model.ItemCompra;
import com.wnra.soldout.model.Promocao;

import java.math.BigDecimal;
import java.util.List;

public class PromocaoUtils {

    public static BigDecimal descontarValorPromocao(List<ItemCompra> itensCompra) {
        BigDecimal valorTotalComPromocao = BigDecimal.ZERO;

        for(var itemCompra : itensCompra){
            Promocao promocao = itemCompra.getPromocaoUtilizada();

            if (Boolean.TRUE.equals(promocao.getIsValorPorcentagem())) {
                itemCompra.setValor(BigDecimal.valueOf(itemCompra.getValor().doubleValue() - (itemCompra.getValor().doubleValue() * CalculosUtils.converterValorParaPorcentagem(promocao.getValor()))));
            } else {
                itemCompra.setValor(BigDecimal.valueOf(itemCompra.getValor().doubleValue() - promocao.getValor().doubleValue()));
            }

            valorTotalComPromocao = BigDecimal.valueOf(valorTotalComPromocao.doubleValue() + itemCompra.getValor().doubleValue());

        }

        return valorTotalComPromocao;
    }

    public static BigDecimal descontarValorPromocao(Promocao promocao, BigDecimal valor){
        if (Boolean.TRUE.equals(promocao.getIsValorPorcentagem())){
            return BigDecimal.valueOf(valor.doubleValue() - (valor.doubleValue() * CalculosUtils.converterValorParaPorcentagem(promocao.getValor())));
        }

        return BigDecimal.valueOf(valor.doubleValue() - promocao.getValor().doubleValue());
    }
}
