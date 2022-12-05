package com.wnra.soldout.category;

import com.wnra.soldout.common.GenericService;
import com.wnra.soldout.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class CategoryService extends GenericService<Category, String> {
    public CategoryService(JpaRepository<Category, String> repository) {
        super(repository);
    }

    public Category save(Category category) {
        category.setId(UUID.randomUUID().toString());
        category.setAdditionDate(LocalDateTime.now());
        category.setLastUpdate(LocalDateTime.now());
        return repository.save(category);
    }

    public Category update(String categoryId, Category updatedCategory) {
        Category oldCategory = findById(categoryId).orElseThrow();
        updatedCategory.setId(oldCategory.getId());
        updatedCategory.setAdditionDate(oldCategory.getAdditionDate());
        updatedCategory.setLastUpdate(LocalDateTime.now());
        return repository.save(updatedCategory);
    }

}
