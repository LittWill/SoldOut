package com.wnra.soldout.coupon.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class RequestCouponDTO {
    @NotBlank
    private String code;
    @NotNull
    private LocalDateTime expirationDate;
    @NotNull
    @Positive
    private BigDecimal value;
    @NotNull
    private Boolean isFreightCoupon;
    @NotNull
    private Boolean isValuePercentage;
}
