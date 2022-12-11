package com.wnra.soldout.domain;

import com.wnra.soldout.domain.crud.CrudListener;
import com.wnra.soldout.domain.crud.CrudOperations;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "promotion")
@EntityListeners(CrudListener.class)
public class Promotion implements CrudOperations {
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
    @OneToMany
    @JoinColumn(name = "prd_prm_id")
    @ToString.Exclude
    private List<Product> products;

    @Override
    public void saveExtraOperations() {
        LocalDateTime now = LocalDateTime.now();
        this.creationDate = now;
        this.lastUpdate = now;
    }

    @Override
    public void beforeUpdate() {
        this.lastUpdate = LocalDateTime.now();
    }
}
