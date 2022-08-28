package com.wnra.soldout.genero;

import com.wnra.soldout.common.service.GenericService;
import com.wnra.soldout.model.Genero;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService extends GenericService<Genero, String> {

    public List<Genero> obterTodosPorId(List<String> idsGeneros) {
        return super.repository.findAllById(idsGeneros);
    }

}
