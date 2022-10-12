package com.wnra.soldout.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Promotion {

    @Id
    @Column(updatable = false)
    private String id;

    @Column(nullable = false, updatable = false)
    private LocalDateTime addDate;

    @Column(nullable = false)
    private LocalDateTime expDate;

    @Column(nullable = false)
    private BigDecimal value;

    @Column(nullable = false)
    private Boolean isValuePercentage;

    public Promotion(LocalDateTime expDate, BigDecimal value, Boolean isValuePercentage) {
        this.id = UUID.randomUUID().toString();
        this.addDate = LocalDateTime.now();
        this.expDate = expDate;
        this.value = value;
        this.isValuePercentage = isValuePercentage;
    }

    public Promotion(String id){
        this.id = id;
    }

}
