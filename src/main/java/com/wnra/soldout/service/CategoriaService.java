package com.wnra.soldout.service;

import com.wnra.soldout.model.Categoria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService extends GenericService<Categoria, String> {

    public List<Categoria> obterTodosPorId(List<String> idsCategorias) {
        return super.repository.findAllById(idsCategorias);
    }

}
