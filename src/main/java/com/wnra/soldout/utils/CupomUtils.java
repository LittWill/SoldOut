package com.wnra.soldout.utils;

import com.wnra.soldout.model.Compra;
import com.wnra.soldout.model.Cupom;
import com.wnra.soldout.model.ItemCompra;
import com.wnra.soldout.model.Promocao;

import java.math.BigDecimal;
import java.util.List;

public class CupomUtils {

    public static Compra aplicarCupom(Cupom cupom, Compra compra) {
        if (cupom.getDataExpiracao() != null && DateUtils.isDataExpirada(cupom.getDataExpiracao())){
            throw new RuntimeException("Cupom expirado! Tente novamente!");
        }

        BigDecimal valorTotalCompra;

        List<ItemCompra> itensCompra = compra.getItensCompra();

        valorTotalCompra = BigDecimal.valueOf(itensCompra.stream().mapToDouble(itemCompra -> itemCompra.getValor().doubleValue() * itemCompra.getQuantidade()).sum());

        BigDecimal valorTotalDescontoPromocoes = BigDecimal.valueOf(0);

        for (var itemCompra : itensCompra){
            Promocao promocao = itemCompra.getProduto().getPromocao();
            BigDecimal valorDescontoPromocao;

            if (Boolean.TRUE.equals(promocao.getIsValorPorcentagem())){
                valorDescontoPromocao = BigDecimal.valueOf(itemCompra.getValor().doubleValue() * CalculosUtils.converterValorParaPorcentagem(promocao.getValor()));
            }
            else {
                valorDescontoPromocao = promocao.getValor();
            }

            valorTotalDescontoPromocoes = BigDecimal.valueOf(valorTotalDescontoPromocoes.doubleValue() + valorDescontoPromocao.doubleValue());
        }

        valorTotalCompra = valorTotalCompra.subtract(valorTotalDescontoPromocoes);

        System.out.println("O valor total da compra é: " + valorTotalCompra);

        if (cupom.getValorMinimo() != null && valorTotalCompra.doubleValue() < cupom.getValorMinimo().doubleValue()){
            throw new RuntimeException(String.format("O valor mínimo para utilização desse cupom é R$%.2f Valor da sua compra: R$%.2f", cupom.getValorMinimo(), valorTotalCompra.doubleValue()));
        }

        if (cupom.getValorMinimo() != null && valorTotalCompra.doubleValue() > cupom.getValorMaximo().doubleValue()){
            throw new RuntimeException(String.format("O valor máximo para utilização desse cupom é R$%.2f. Valor da sua compra: R$%.2f", cupom.getValorMaximo(), valorTotalCompra.doubleValue()));
        }

        compra.setCupom(cupom);

        return compra;

    }

    public static BigDecimal descontarValorCupom(Cupom cupom, BigDecimal valor){
        if (Boolean.TRUE.equals(cupom.getIsValorPorcentagem())){
            return BigDecimal.valueOf(valor.doubleValue() - (valor.doubleValue() * CalculosUtils.converterValorParaPorcentagem(cupom.getValor())));
        }

        return BigDecimal.valueOf(valor.doubleValue() - cupom.getValor().doubleValue());
    }
}
