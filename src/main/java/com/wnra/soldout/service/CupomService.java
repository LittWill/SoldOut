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

    public Cupom obterPorCodigo(String codigo){
        return cupomRepository.findByCodigo(codigo).orElseThrow(() -> new RuntimeException("Cupom não encontrado!"));
    }

    public ValorProdutosCarrinhoDTO aplicarCupom(String codigo, ValorProdutosCarrinhoDTO dto){
        Cupom cupom = this.obterPorCodigo(codigo);

        if (Boolean.TRUE.equals(cupom.getIsValorPorcentagem())){
            dto.setValorProdutos(BigDecimal.valueOf(dto.getValorProdutos().doubleValue() - (dto.getValorProdutos().doubleValue() * cupom.converterValorParaPorcentagem())));
        }
        else {
            dto.setValorProdutos(BigDecimal.valueOf(dto.getValorProdutos().doubleValue() - cupom.getValor().doubleValue()));
        }

        return dto;
    }
    
    public Cupom atualizar(String id, Cupom cupomAtualizado){
        Cupom cupomAntigo = super.obter(id);
        cupomAtualizado.setId(cupomAntigo.getId());
        cupomAtualizado.setCodigo(cupomAntigo.getCodigo());
        cupomAtualizado.setDataCriacao(cupomAntigo.getDataCriacao());
        return super.repository.save(cupomAtualizado);
    }
}
