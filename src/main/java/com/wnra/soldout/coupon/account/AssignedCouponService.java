package com.wnra.soldout.coupon.account;

import com.wnra.soldout.common.GenericService;
import com.wnra.soldout.domain.AssignedCoupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AssignedCouponService extends GenericService<AssignedCoupon, String> {


    public AssignedCouponService(JpaRepository<AssignedCoupon, String> repository) {
        super(repository);
    }
/*
    public void assignToAccounts(RequestCouponAssignDTO requestCouponAssignDTO) {
        String couponId = requestCouponAssignDTO.getCouponId();
        List<String> accountsIds = requestCouponAssignDTO.getAccountsIds();

        Coupon coupon = findById(couponId).orElseThrow();

        List<Account> accountList = accountsIds.stream()
                .map(accountId -> accountRepository.findById(accountId)
                        .orElseThrow(() -> new NoSuchElementException("Um ou mais ID's da conta não foram encontrados!"))).collect(Collectors.toList());

        accountList.stream().map(Account::getCoupons)
                .map(Optional::ofNullable)
                .map(optCoupons -> optCoupons.orElseGet(Arrays::asList))
                .forEach(accountCoupons -> accountCoupons.add(coupon));

        repository.save(coupon);
    }

 */


}
