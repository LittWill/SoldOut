package com.wnra.soldout.domain;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AssignedCoupon {
    @Id
    @Column(name = "aca_id")
    private String id;
    @Column(name = "aca_is_used")
    private Boolean isUsed;
    @ManyToOne
    @JoinColumn(name = "aca_cpn_id")
    private Coupon coupon;
    @ManyToOne
    @JoinColumn(name = "aca_acc_id")
    private Account account;
}
