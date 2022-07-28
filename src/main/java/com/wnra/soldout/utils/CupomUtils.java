package com.wnra.soldout.utils;

import com.wnra.soldout.model.Compra;
import com.wnra.soldout.model.Cupom;

import java.math.BigDecimal;

public class CupomUtils {

    public static Compra aplicarCupom(Cupom cupom, Compra compra) {
        double valorCompra = CompraUtils.extrairValorCustomCompra(compra, true, false, false).doubleValue();

        if (cupom.getDataExpiracao() != null && DateUtils.isDataExpirada(cupom.getDataExpiracao())){
            throw new RuntimeException("Cupom expirado! Tente novamente!");
        }

        if (cupom.getValorMinimo() != null && valorCompra < cupom.getValorMinimo().doubleValue()){
            throw new RuntimeException(String.format("O valor mínimo para utilização desse cupom é R$%.2f Valor da sua compra: R$%.2f", cupom.getValorMinimo(), valorCompra));
        }

        if (cupom.getValorMinimo() != null && valorCompra > cupom.getValorMaximo().doubleValue()){
            throw new RuntimeException(String.format("O valor máximo para utilização desse cupom é R$%.2f. Valor da sua compra: R$%.2f", cupom.getValorMaximo(), valorCompra));
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
