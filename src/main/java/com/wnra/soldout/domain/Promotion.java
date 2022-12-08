package com.wnra.soldout.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "promotion")
public class Promotion {
    @Id
    @Column(name = "prm_id")
    private String id;
    @Column(name = "prm_creation_date")
    private LocalDateTime creationDate;
    @Column(name = "prm_last_update")
    private LocalDateTime lastUpdate;
    @Column(name = "prm_value")
    private BigDecimal value;
    @Column(name = "prm_is_value_percentage")
    private Boolean isPercentageValue;
}
