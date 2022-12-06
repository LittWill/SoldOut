package com.wnra.soldout.coupon.account;

import com.wnra.soldout.domain.AssignedCoupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignedCouponRepository extends JpaRepository<AssignedCoupon, String> {
}
