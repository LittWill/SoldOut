package com.wnra.soldout.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Coupon {

    @Id
    @Column(updatable = false)
    private String id;

    @Column(length = 50, unique = true, updatable = false, nullable = false)
    private String code;

    @Column(nullable = false)
    private BigDecimal value;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(nullable = false, updatable = false)
    private LocalDateTime addDate;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime expDate;

    @Column(nullable = false)
    private Boolean isValuePercentage;

    @Column(nullable = false)
    private Boolean isShippingCoupon;

    private BigDecimal minValue;
    private BigDecimal maxValue;

    public Coupon(String code, BigDecimal value, LocalDateTime expDate, Boolean isValuePercentage,
                  Boolean isShippingCoupon) {
        this.id = UUID.randomUUID().toString();
        this.code = code;
        this.value = value;
        this.expDate = expDate;
        this.isValuePercentage = isValuePercentage;
        this.isShippingCoupon = isShippingCoupon;
        this.addDate = LocalDateTime.now();
    }

}
