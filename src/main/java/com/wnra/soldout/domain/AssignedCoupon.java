package com.wnra.soldout.domain;

import com.wnra.soldout.domain.crud.CrudListener;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@EntityListeners(CrudListener.class)
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
