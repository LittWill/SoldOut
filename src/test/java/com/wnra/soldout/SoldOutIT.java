package com.wnra.soldout;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wnra.soldout.brand.BrandRepository;
import com.wnra.soldout.category.CategoryRepository;
import com.wnra.soldout.coupon.CouponRepository;
import com.wnra.soldout.product.ProductRepository;
import com.wnra.soldout.promotion.PromotionRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;


@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.DisplayName.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Slf4j
public class SoldOutIT {

    @Autowired
    protected PromotionRepository promotionRepository;
    @Autowired
    protected ProductRepository productRepository;
    @Autowired
    protected BrandRepository brandRepository;
    @Autowired
    protected CategoryRepository categoryRepository;
    @Autowired
    protected CouponRepository couponRepository;
    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected ObjectMapper objectMapper;

}
