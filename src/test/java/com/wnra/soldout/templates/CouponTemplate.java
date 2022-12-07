package com.wnra.soldout.templates;

import com.wnra.soldout.coupon.dto.RequestCouponDTO;
import com.wnra.soldout.domain.Coupon;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class CouponTemplate {

    public static Coupon getRequest() {
        return Coupon.builder()
                .code("VALID_CODE")
                .expirationDate(LocalDateTime.now().plusWeeks(1))
                .value(BigDecimal.TEN)
                .isFreightCoupon(Boolean.FALSE)
                .isValuePercentage(Boolean.TRUE)
                .build();
    }


    public static Coupon getValid() {
        return Coupon.builder()
                .id(UUID.randomUUID().toString())
                .code("VALID_CODE")
                .creationDate(LocalDateTime.now())
                .expirationDate(LocalDateTime.now().plusWeeks(1))
                .value(BigDecimal.TEN)
                .isFreightCoupon(Boolean.FALSE)
                .isValuePercentage(Boolean.TRUE)
                .build();

    }

    public static RequestCouponDTO getValidDTO() {
        return RequestCouponDTO.builder()
                .code("VALID_CODE")
                .expirationDate(LocalDateTime.now().plusWeeks(1))
                .value(BigDecimal.TEN)
                .isFreightCoupon(Boolean.FALSE)
                .isValuePercentage(Boolean.TRUE)
                .build();
    }

}
