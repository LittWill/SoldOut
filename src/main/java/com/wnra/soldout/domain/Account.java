package com.wnra.soldout.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "account")
public class Account {
    @Id
    @Column(name = "acc_id")
    private String id;
    @Column(name = "acc_creation_date")
    private String creationDate;
    @Column(name = "acc_password")
    private String password;
    @Embedded
    private Customer customer;
    @OneToMany(mappedBy = "account")
    private List<AssignedCoupon> assignedCoupons;
}
