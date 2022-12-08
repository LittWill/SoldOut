package com.wnra.soldout.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Customer {
    @Column(name = "acc_customer_fn")
    private String firstName;
    @Column(name = "acc_customer_ln")
    private String lastName;
    @Column(name = "acc_customer_email")
    private String email;
    @Column(name = "acc_customer_phone")
    private String phone;
}
