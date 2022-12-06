package com.wnra.soldout.coupon.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ResponseCouponDTO {
    private String id;
    private String code;
    private String creationDate;
    private String expirationDate;
    private BigDecimal value;
    private Boolean isFreightCoupon;
    private Boolean isValuePercentage;
}
