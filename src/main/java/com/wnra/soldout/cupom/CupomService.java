package com.wnra.soldout.cupom;

import com.wnra.soldout.common.service.GenericService;
import com.wnra.soldout.model.Cupom;
import com.wnra.soldout.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CupomService extends GenericService<Cupom, String> {

    @Autowired
    private CupomRepository cupomRepository;


    public Cupom obterPorCodigo(String codigo) {
        Cupom cupom = cupomRepository.findByCodigo(codigo).orElseThrow(() -> new RuntimeException("Cupom não " +
                "encontrado!"));

        if (DateUtils.isDataExpirada(cupom.getDataExpiracao())){
            throw new RuntimeException("Esse cupom expirou!");
        }

        return cupom;
    }

    public Cupom atualizar(String id, Cupom cupomAtualizado) {
        Cupom cupomAntigo = super.obter(id);
        cupomAtualizado.setId(cupomAntigo.getId());
        cupomAtualizado.setCodigo(cupomAntigo.getCodigo());
        cupomAtualizado.setDataCriacao(cupomAntigo.getDataCriacao());
        return super.repository.save(cupomAtualizado);
    }



}
