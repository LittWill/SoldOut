package com.wnra.soldout.coupon;

import com.wnra.soldout.domain.Coupon;
import com.wnra.soldout.templates.CouponTemplate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CouponServiceTest {

    @InjectMocks
    private CouponService couponService;
    @Mock
    private CouponRepository couponRepository;

    private Coupon coupon;

    @BeforeEach
    public void setup() {
        coupon = CouponTemplate.getValid();
        MockitoAnnotations.openMocks(this);
        when(couponRepository.findById(any())).thenReturn(Optional.of(coupon));
    }
    @DisplayName("A atualização de valores antes de salvar está funcionando")
    @Test
    void testUpdate() {
        Coupon updatedCoupon = CouponTemplate.getValid();

        updatedCoupon.setCode("UPDATED_CODE");
        updatedCoupon.setExpirationDate(LocalDateTime.now().plusWeeks(2));
        updatedCoupon.setValue(BigDecimal.valueOf(20.0));
        updatedCoupon.setIsFreightCoupon(true);
        updatedCoupon.setIsValuePercentage(false);

        couponService.update(coupon.getId(), updatedCoupon);

        assertThat(coupon.getCode()).isNotEqualTo(updatedCoupon.getCode());
        assertThat(coupon.getExpirationDate()).isNotEqualTo(updatedCoupon.getExpirationDate());
        assertThat(coupon.getValue()).isNotEqualTo(updatedCoupon.getValue());
        assertThat(coupon.getIsFreightCoupon()).isNotEqualTo(updatedCoupon.getIsFreightCoupon());
        assertThat(coupon.getIsValuePercentage()).isNotEqualTo(updatedCoupon.getIsValuePercentage());
    }
}
