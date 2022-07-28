package com.wnra.soldout.utils;

import java.math.BigDecimal;

public class CalculosUtils {

    public static Double converterValorParaPorcentagem(BigDecimal valor) {
        return valor.doubleValue() / 100;
    }
}
