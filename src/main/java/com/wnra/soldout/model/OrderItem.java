package com.wnra.soldout.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class OrderItem {

    @Id
    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private BigDecimal value;

    @ManyToOne(optional = false)
    @JoinColumn(updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Size size;

    @ManyToOne
    private Promotion promotionUsed;

    public OrderItem(Integer amount, BigDecimal value, Product product, Size size) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.value = value;
        this.product = product;
        this.size = size;
    }

}
