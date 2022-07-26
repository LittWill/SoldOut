package com.wnra.soldout.service;

import com.wnra.soldout.model.Marca;
import org.springframework.stereotype.Service;

@Service
public class MarcaService extends GenericService<Marca, String> {

    public Marca alterar(String id, Marca marcaAtualizada){
        Marca marcaAntiga = super.obter(id);
        marcaAtualizada.setId(marcaAntiga.getId());
        return super.salvar(marcaAtualizada);
    }

}
