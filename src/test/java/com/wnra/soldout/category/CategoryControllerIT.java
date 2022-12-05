package com.wnra.soldout.category;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wnra.soldout.SoldOutIT;
import com.wnra.soldout.templates.CategoryTemplate;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
class CategoryControllerIT extends SoldOutIT {

    private static final String API_SUFFIX = "/categories";

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private MockMvc mockMvc;

    private String categoryId;

    @BeforeEach
    void setup() {
        categoryId = categoryService.save(CategoryTemplate.getValid()).getId();
    }

    @AfterEach
    void clean() {
        categoryRepository.deleteAll();
    }

    @DisplayName("O endpoint para salvar categorias está funcionando")
    @SneakyThrows
    @Test
    void testSave() {
        mockMvc.perform(post(API_SUFFIX)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsBytes(CategoryTemplate.getValidRequestDTO())))
                .andExpect(status().isCreated());
    }

    @DisplayName("O endpoint para buscar cateogrias está funcionando")
    @SneakyThrows
    @Test
    void testFindAll() {
        mockMvc.perform(get(API_SUFFIX))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].name").value("CATEGORY_NAME"))
                .andExpect(jsonPath("$[0].description").value("CATEGORY_DESCRIPTION"))
                .andExpect(jsonPath("$[0].additionDate").exists());
    }

    @DisplayName("O endpoint para buscar uma marca está funcionando")
    @SneakyThrows
    @Test
    void testFind() {
        mockMvc.perform(get(API_SUFFIX + "/" + categoryId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value("CATEGORY_NAME"))
                .andExpect(jsonPath("$.description").value("CATEGORY_DESCRIPTION"))
                .andExpect(jsonPath("$.additionDate").exists());
    }


    @DisplayName("O endpoint para atualizar uma marca está funcionando")
    @SneakyThrows
    @Test
    void testUpdate() {
        mockMvc.perform(put(API_SUFFIX + "/" + categoryId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsBytes(CategoryTemplate.getValidRequestDTO())))
                .andExpect(status().isOk());
    }

    @DisplayName("O endpoint para excluir uma marca está funcionando")
    @SneakyThrows
    @Test
    void testDelete() {
        mockMvc.perform(delete(API_SUFFIX + "/" + categoryId))
                .andExpect(status().isOk());
    }

}
