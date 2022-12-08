package com.wnra.soldout.coupon;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wnra.soldout.SoldOutIT;
import com.wnra.soldout.domain.Coupon;
import com.wnra.soldout.templates.CouponTemplate;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@RequiredArgsConstructor
class CouponControllerIT extends SoldOutIT {

    private static final String API_SUFFIX = "/coupons";

    @Autowired
    private CouponService couponService;

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private MockMvc mockMvc;
    private String couponId;

    private Coupon coupon;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        coupon = couponService.save(CouponTemplate.getRequest());
        couponId = coupon.getId();
    }

    @AfterEach
    void clean() {
        couponRepository.deleteAll();
    }

    @DisplayName("O endpoint para salvar cupons está funcionando")
    @SneakyThrows
    @Test
    void testSave() {
        mockMvc.perform(post(API_SUFFIX)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(CouponTemplate.getValidDTO())))
                .andExpect(status().isCreated());
        assertThat(List.of(coupon.getId(), coupon.getCreationDate())).allMatch(Objects::nonNull);
    }

    @DisplayName("O endpoint para buscar cupons está funcionando")
    @SneakyThrows
    @Test
    void testFindAll() {
        mockMvc.perform(get(API_SUFFIX)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @DisplayName("O endpoint para buscar uma cupom está funcionando")
    @SneakyThrows
    @Test
    void testFind() {
        mockMvc.perform(get(API_SUFFIX + "/" + couponId))
                .andExpect(status().isOk());
    }


    @DisplayName("O endpoint para atualizar um cupom está funcionando")
    @SneakyThrows
    @Test
    void testUpdate() {
        mockMvc.perform(put(API_SUFFIX + "/" + couponId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(CouponTemplate.getValidDTO())))
                .andExpect(status().isOk());
    }

    @DisplayName("O endpoint para excluir um cupom está funcionando")
    @SneakyThrows
    @Test
    void testDelete() {
        mockMvc.perform(delete(API_SUFFIX + "/" + couponId))
                .andExpect(status().isOk());
    }

}
