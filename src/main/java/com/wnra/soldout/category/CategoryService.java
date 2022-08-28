package com.wnra.soldout.category;

import com.wnra.soldout.common.service.GenericService;
import com.wnra.soldout.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService extends GenericService<Category, String> {

    public List<Category> obterTodosPorId(List<String> idsCategorias) {
        return super.repository.findAllById(idsCategorias);
    }

}
