package com.wnra.soldout.domain;

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
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "coupon")
@EntityListeners(CallBackListener.class)
public class Coupon implements DefaultOperations {

    @Id
    @Column(name = "cpn_id")
    private String id;
    @Column(name = "cpn_code")
    private String code;
    @Column(name = "cpn_creation_date")
    private LocalDateTime creationDate;
    @Column(name = "cpn_expiration_date")
    private LocalDateTime expirationDate;
    @Column(name = "cpn_value")
    private BigDecimal value;
    @Column(name = "cpn_is_freight_coupon")
    private Boolean isFreightCoupon;
    @Column(name = "cpn_is_value_percentage")
    private Boolean isValuePercentage;

    @Override
    public void beforeSave() {
        this.id = UUID.randomUUID().toString();
        this.creationDate = LocalDateTime.now();
    }
}
