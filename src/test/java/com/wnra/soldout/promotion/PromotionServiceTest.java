package com.wnra.soldout.promotion;


import com.wnra.soldout.domain.Product;
import com.wnra.soldout.domain.Promotion;
import com.wnra.soldout.product.ProductRepository;
import com.wnra.soldout.templates.PromotionTemplate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PromotionServiceTest {

    @InjectMocks
    private PromotionService promotionService;
    @Mock
    private PromotionRepository promotionRepository;
    @Mock
    private ProductRepository productRepository;
    private Promotion promotion;

    @BeforeEach
    void setup() {
        promotion = PromotionTemplate.getFull();
        MockitoAnnotations.openMocks(this);
        when(productRepository.existsById(any())).thenReturn(true);
        when(promotionRepository.findById(any())).thenReturn(Optional.of(promotion));
    }

    @DisplayName("Deve falhar ao não encontrar o ID de algum pedido no payload.")
    @Test
    void testShouldFailWhenNotFindSomeProduct() {
        promotion.setProducts(List.of(mock(Product.class)));
        when(productRepository.existsById(any())).thenReturn(false);
        assertThatCode(() -> promotionService.save(promotion))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage("Um ou mais produtos não encontrados! " + promotion.getProducts().stream().map(Product::getId).collect(Collectors.toList()));
    }

    @DisplayName("Deve manter alguns atributos ao atualizar os dados da promoção.")
    @Test
    void testShouldKeepSomeAttributesOnUpdate() {
        Promotion updatedPromotion = PromotionTemplate.getFull();
        promotionService.updatePromotion(promotion.getId(), updatedPromotion);
        assertThat(List.of(updatedPromotion.getId(), updatedPromotion.getCreationDate()))
                .isEqualTo(List.of(promotion.getId(), promotion.getCreationDate()));


    }

}
