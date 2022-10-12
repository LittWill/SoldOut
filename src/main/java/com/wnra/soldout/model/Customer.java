package com.wnra.soldout.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {

    @Column(nullable = false, updatable = false)
    private String firstName;
    @Column(nullable = false, updatable = false)
    private String lastName;
    @Column(nullable = false, updatable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String phone;

}
