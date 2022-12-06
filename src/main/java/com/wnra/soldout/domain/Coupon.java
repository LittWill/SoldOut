package com.wnra.soldout.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "coupon")
public class Coupon {

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
}
