package com.wnra.soldout.coupon;

import com.wnra.soldout.coupon.dto.RequestCouponDTO;
import com.wnra.soldout.coupon.dto.ResponseCouponDTO;
import com.wnra.soldout.domain.Coupon;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public interface CouponMapper {

    Coupon toModel(RequestCouponDTO dto);

    ResponseCouponDTO toResponse(Coupon coupon);
}
