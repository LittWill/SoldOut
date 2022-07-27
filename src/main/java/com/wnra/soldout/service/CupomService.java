package com.wnra.soldout.service;

import com.wnra.soldout.dto.ValorProdutosCarrinhoDTO;
import com.wnra.soldout.model.Cupom;
import com.wnra.soldout.repository.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CupomService extends GenericService<Cupom, String> {

    @Autowired
    private CupomRepository cupomRepository;

    public Cupom obterPorCodigo(String codigo) {
        return cupomRepository.findByCodigo(codigo).orElseThrow(() -> new RuntimeException("Cupom não encontrado!"));
    }

    public ValorProdutosCarrinhoDTO aplicarCupom(String codigo, ValorProdutosCarrinhoDTO dto) {
        Cupom cupom = this.obterPorCodigo(codigo);

        BigDecimal valor = Boolean.TRUE.equals(cupom.getIsFreteCupom()) ? dto.getValorFrete() : dto.getValorProdutos();

        if (cupom.getValorMinimo() != null && dto.getValorProdutos().doubleValue() < cupom.getValorMinimo().doubleValue()) {
            throw new RuntimeException("Os itens da sacola não atingiram o valor mínimo!");
        }

        if (cupom.getValorMaximo() != null && dto.getValorProdutos().doubleValue() > cupom.getValorMaximo().doubleValue()) {
            throw new RuntimeException(String.format("Os itens da sacola ultrapassaram o valor máximo de R$%.2f do " +
                    "cupom.", cupom.getValorMaximo().doubleValue()));
        }

        if (Boolean.TRUE.equals(cupom.getIsValorPorcentagem())) {
            valor = BigDecimal.valueOf(valor.doubleValue() - (valor.doubleValue() * cupom.converterValorParaPorcentagem()));
        } else {
            valor = BigDecimal.valueOf(valor.doubleValue() - cupom.getValor().doubleValue());
        }

        if (Boolean.TRUE.equals(cupom.getIsFreteCupom())) {
            dto.setValorFrete(valor);
        } else {
            dto.setValorProdutos(valor);
        }

        return dto;
    }

    public Cupom atualizar(String id, Cupom cupomAtualizado) {
        Cupom cupomAntigo = super.obter(id);
        cupomAtualizado.setId(cupomAntigo.getId());
        cupomAtualizado.setCodigo(cupomAntigo.getCodigo());
        cupomAtualizado.setDataCriacao(cupomAntigo.getDataCriacao());
        return super.repository.save(cupomAtualizado);
    }

}
