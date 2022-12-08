package com.wnra.soldout.coupon;

import com.wnra.soldout.common.GenericService;
import com.wnra.soldout.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CouponService extends GenericService<Coupon, String> {
    public CouponService(JpaRepository<Coupon, String> repository) {
        super(repository);
    }

    public Coupon update(String couponId, Coupon updatedCoupon) {
        Coupon oldCoupon = findById(couponId).orElseThrow();
        updatedCoupon.setId(oldCoupon.getId());
        updatedCoupon.setCreationDate(oldCoupon.getCreationDate());
        return repository.save(updatedCoupon);
    }

}
