package com.wnra.soldout.coupon.account.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class RequestCouponAssignDTO {
    @NotBlank
    private String couponId;
    @NotEmpty
    private List<String> accountsIds;
}
