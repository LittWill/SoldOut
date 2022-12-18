package com.wnra.soldout.promotion;

import com.wnra.soldout.SoldOutIT;
import com.wnra.soldout.domain.Brand;
import com.wnra.soldout.domain.Category;
import com.wnra.soldout.domain.Product;
import com.wnra.soldout.domain.Promotion;
import com.wnra.soldout.templates.BrandTemplate;
import com.wnra.soldout.templates.CategoryTemplate;
import com.wnra.soldout.templates.ProductTemplate;
import com.wnra.soldout.templates.PromotionTemplate;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PromotionControllerIT extends SoldOutIT {

    private static final String API_SUFFIX = "/promotions";
    private String promotionId;

    private String productId;


    @BeforeEach
    void setup() {
        Brand brand = brandRepository.save(BrandTemplate.getValid());
        Category category = categoryRepository.save(CategoryTemplate.getValid());
        Product product = productRepository.save(ProductTemplate.getValid(brand, category));
        Promotion promotion = promotionRepository.save(PromotionTemplate.getNew(product));
        productId = product.getId();
        promotionId = promotion.getId();

    }

    @AfterEach
    void clean() {
        promotionRepository.deleteAll();
    }

    @DisplayName("As promoções estão sendo salvas corretamente.")
    @SneakyThrows
    @Test
    void testSave() {
        mockMvc.perform(post(API_SUFFIX)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(PromotionTemplate.getNewDTO(productId))))
                .andExpect(status().isCreated());
    }

    @DisplayName("As promoções estão sendo retornadas corretamente.")
    @SneakyThrows
    @Test
    void testFindAll() {
        mockMvc.perform(get(API_SUFFIX)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @DisplayName("O endpoint para buscar uma promoção está funcionando")
    @SneakyThrows
    @Test
    void testFind() {
        mockMvc.perform(get(API_SUFFIX + "/" + promotionId))
                .andExpect(status().isOk());
    }

    @DisplayName("O endpoint para atualizar uma promoção está funcionando")
    @SneakyThrows
    @Test
    void testUpdate() {
        mockMvc.perform(put(API_SUFFIX + "/" + promotionId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(PromotionTemplate.getNewDTO(productId))))
                .andExpect(status().isOk());
    }

    @DisplayName("O endpoint para excluir uma promoção está funcionando")
    @SneakyThrows
    @Test
    void testDelete() {
        mockMvc.perform(delete(API_SUFFIX + "/" + promotionId))
                .andExpect(status().isOk());
        assertThat(promotionRepository.findById(promotionId)).isEmpty();
    }

}
