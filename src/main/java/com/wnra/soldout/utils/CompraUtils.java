package com.wnra.soldout.utils;

import com.wnra.soldout.model.Compra;
import com.wnra.soldout.model.ItemCompra;

import java.math.BigDecimal;
import java.util.List;

public class CompraUtils {


    public static BigDecimal extrairValorCustomCompra(Compra compra, boolean comPromocao, boolean comCupom, boolean comFrete) {
        BigDecimal valorCompraCustom;

        List<ItemCompra> itensCompra = compra.getItensCompra();

        valorCompraCustom = BigDecimal.valueOf(itensCompra.stream().mapToDouble(itemCompra -> itemCompra.getValor().doubleValue() * itemCompra.getQuantidade()).sum());

        if (comPromocao) {
            valorCompraCustom = PromocaoUtils.descontarValorPromocao(itensCompra);
        }

        if (comCupom) {
            valorCompraCustom = CupomUtils.descontarValorCupom(compra.getCupom(), valorCompraCustom);
        }

        if (comFrete) {
            valorCompraCustom = BigDecimal.valueOf(valorCompraCustom.doubleValue() + compra.getValorFrete().doubleValue());
        }

        return valorCompraCustom;
    }

    public static BigDecimal extrairValorTotalCompraBruto(Compra compra) {
        BigDecimal valorBrutoCompra;

        List<ItemCompra> itensCompra = compra.getItensCompra();

        valorBrutoCompra =
                BigDecimal.valueOf(itensCompra.stream().mapToDouble(itemCompra -> itemCompra.getValor().doubleValue() * itemCompra.getQuantidade()).sum());

        valorBrutoCompra = BigDecimal.valueOf(valorBrutoCompra.doubleValue() + compra.getValorFrete().doubleValue());

        return valorBrutoCompra;
    }

    public static BigDecimal extrairValorTotalCompraLiquido(Compra compra) {
        BigDecimal valorLiquido;

        List<ItemCompra> itensCompra = compra.getItensCompra();

        //itensCompra = PromocaoUtils.aplicarDescontoPromocao(itensCompra);

        valorLiquido =
                BigDecimal.valueOf(itensCompra.stream().mapToDouble(itemCompra -> itemCompra.getValor().doubleValue() * itemCompra.getQuantidade()).sum());

        valorLiquido = BigDecimal.valueOf(valorLiquido.doubleValue() + compra.getValorFrete().doubleValue());

        valorLiquido = CupomUtils.descontarValorCupom(compra.getCupom(), valorLiquido);

        return valorLiquido;

    }
}
