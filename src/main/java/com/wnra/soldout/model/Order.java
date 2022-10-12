package com.wnra.soldout.model;

import com.wnra.soldout.compra.StatusCompra;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Order {

    @Id
    @Column(updatable = false)
    private String id;

    @Column(nullable = false, updatable = false)
    private LocalDateTime addDate;

    @Column(nullable = false)
    private StatusCompra status;

    @Column(nullable = false)
    private BigDecimal shipValue;

    @ManyToOne(optional = false)
    @JoinColumn(updatable = false)
    private Account account;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(nullable = false)
    private List<OrderItem> orderItems;

    @ManyToOne(optional = false)
    private Adress adress;

    @ManyToOne
    @JoinColumn(name = "coupon_code")
    private Coupon coupon;

    public Order(BigDecimal shipValue, Account account, Adress adress, Coupon coupon, List<OrderItem> orderItems) {
        this.id = UUID.randomUUID().toString();
        this.addDate = LocalDateTime.now();
        this.status = StatusCompra.PROCESSAMENTO;
        this.shipValue = shipValue;
        this.account = account;
        this.adress = adress;
        this.coupon = coupon;
        this.orderItems = orderItems;
    }


}
