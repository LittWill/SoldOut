package com.wnra.soldout.category;

import com.wnra.soldout.domain.Category;
import com.wnra.soldout.templates.CategoryTemplate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CategoryServiceTest {
    @InjectMocks
    private CategoryService categoryService;
    @Mock
    private CategoryRepository categoryRepository;
    private Category category;

    @BeforeEach
    void setup() {
        category = CategoryTemplate.getValid();
        MockitoAnnotations.openMocks(this);
        when(categoryRepository.findById(any())).thenReturn(Optional.of(category));
    }

    @DisplayName("O ID e data de adição foram gerados")
    @Test
    void testSave() {
        categoryService.save(category);
        assertThat(category.getId()).isNotNull();
        assertThat(category.getAdditionDate()).isNotNull();
        assertThat(category.getLastUpdate()).isNotNull();
    }

    @DisplayName("A busca por ID está funcionando")
    @Test
    void testFind() {
        assertThatCode(() -> categoryService.findById(category.getId())).doesNotThrowAnyException();
    }

    @DisplayName("A busca de todas as categorias está trazendo o item salvo")
    @Test
    void testFindAll() {
        assertThat(categoryService.findAll())
                .allMatch(category -> this.category.getId().equals(category.getId()));
    }

    @DisplayName("A atualização de categoria está alterando o atributo name e mantendo os outros")
    @Test
    void testUpdate() {
        category.setAdditionDate(LocalDateTime.now());

        Category updatedcategory = CategoryTemplate.getValid();
        updatedcategory.setName("UPDATED_NAME");
        updatedcategory.setDescription("UPDATE_DESCRIPTION");
        categoryService.update(category.getId(), updatedcategory);

        assertThat(updatedcategory.getId())
                .isEqualTo(category.getId());

        assertThat(updatedcategory.getAdditionDate())
                .isEqualToIgnoringSeconds(category.getAdditionDate());

        assertThat(updatedcategory.getName())
                .isNotEqualTo(category.getName())
                .isEqualTo("UPDATED_NAME");

        assertThat(updatedcategory.getDescription())
                .isNotEqualTo(category.getDescription())
                .isEqualTo("UPDATE_DESCRIPTION");
    }

    @DisplayName("A deleção está funcionando corretamente")
    @Test
    void testDelete() {
        categoryService.deleteById(category.getId());
    }

}
