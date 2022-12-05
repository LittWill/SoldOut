package com.wnra.soldout.brand;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wnra.soldout.SoldOutIT;
import com.wnra.soldout.templates.BrandTemplate;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
class BrandControllerIT extends SoldOutIT {

    private static final String API_SUFFIX = "/brands";

    @Autowired
    private BrandService brandService;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private MockMvc mockMvc;

    private String brandId;

    @BeforeEach
    void setup() {
        brandId = brandService.save(BrandTemplate.getValid()).getId();
    }

    @AfterEach
    void clean() {
        brandRepository.deleteAll();
    }

    @DisplayName("O endpoint para salvar marcas está funcionando")
    @SneakyThrows
    @Test
    void testSave() {
        mockMvc.perform(post(API_SUFFIX)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsBytes(BrandTemplate.getValidRequestDTO())))
                .andExpect(status().isCreated());
    }

    @DisplayName("O endpoint para buscar marcas está funcionando")
    @SneakyThrows
    @Test
    void testFindAll() {
        mockMvc.perform(get(API_SUFFIX))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("BRAND_NAME"))
                .andExpect(jsonPath("$[0].addDate").exists());
    }

    @DisplayName("O endpoint para buscar uma marca está funcionando")
    @SneakyThrows
    @Test
    void testFind() {
        mockMvc.perform(get(API_SUFFIX + "/" + brandId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("BRAND_NAME"));
    }


    @DisplayName("O endpoint para atualizar uma marca está funcionando")
    @SneakyThrows
    @Test
    void testUpdate() {
        mockMvc.perform(put(API_SUFFIX + "/" + brandId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsBytes(BrandTemplate.getValidRequestDTO())))
                .andExpect(status().isOk());
    }

    @DisplayName("O endpoint para excluir uma marca está funcionando")
    @SneakyThrows
    @Test
    void testDelete() {
        mockMvc.perform(delete(API_SUFFIX + "/" + brandId))
                .andExpect(status().isOk());
    }

}
