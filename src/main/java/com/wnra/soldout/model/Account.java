package com.wnra.soldout.model;

import com.wnra.soldout.conta.StatusConta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Account {

    @Id
    @Column(updatable = false)
    private String id;

    @Column(nullable = false, updatable = false)
    private LocalDateTime addDate;

    @Column(nullable = false)
    private StatusConta accountStatus;

    @Column(nullable = false)
    private String password;

    @Embedded
    private Customer customer;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "address_id")
    private List<Adress> adresses;

    @OneToMany(mappedBy = "account")
    private List<Favorite> favorites;

    @OneToMany(mappedBy = "account")
    private List<Order> purchases;

    @ManyToMany
    private List<Coupon> coupons;

    public Account(Customer customer, String password) {
        this.id = UUID.randomUUID().toString();
        this.addDate = LocalDateTime.now();
        this.customer = customer;
        this.password = password;
        this.accountStatus = StatusConta.INATIVA;
    }


}
