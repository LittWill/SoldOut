package com.wnra.soldout.service;

import com.wnra.soldout.model.Cupom;
import org.springframework.stereotype.Service;

@Service
public class CupomService extends GenericService<Cupom, String> {
    
    public Cupom atualizar(String id, Cupom cupomAtualizado){
        Cupom cupomAntigo = super.obter(id);
        cupomAtualizado.setId(cupomAntigo.getId());
        cupomAtualizado.setCodigo(cupomAntigo.getCodigo());
        cupomAtualizado.setDataCriacao(cupomAntigo.getDataCriacao());
        return super.repository.save(cupomAtualizado);
    }
}
