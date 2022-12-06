package com.wnra.soldout.coupon;

import com.wnra.soldout.common.GenericService;
import com.wnra.soldout.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class CouponService extends GenericService<Coupon, String> {
    public CouponService(JpaRepository<Coupon, String> repository) {
        super(repository);
    }

    public Coupon save(Coupon coupon) {
        coupon.setId(UUID.randomUUID().toString());
        coupon.setCreationDate(LocalDateTime.now());
        return repository.save(coupon);
    }

    public Coupon update(String couponId, Coupon updatedCoupon) {
        Coupon oldCoupon = findById(couponId).orElseThrow();
        updatedCoupon.setId(oldCoupon.getId());
        updatedCoupon.setCreationDate(oldCoupon.getCreationDate());
        return repository.save(updatedCoupon);
    }

}
