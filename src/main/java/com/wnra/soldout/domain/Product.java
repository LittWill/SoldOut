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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@EntityListeners(CrudListener.class)
public class Product implements CrudOperations {
    @Id
    @Column(name = "prd_id")
    private String id;
    @Column(name = "prd_addition_date")
    private LocalDateTime additionDate;
    @Column(name = "prd_last_update")
    private LocalDateTime lastUpdate;
    @Column(name = "prd_model")
    private String model;
    @Column(name = "prd_description")
    private String description;
    @Column(name = "prd_price")
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "prd_brd_id")
    private Brand brand;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "prd_prm_id")
    private Promotion currentPromotion;
    @ManyToMany
    @JoinTable(name = "category_has_product", joinColumns = @JoinColumn(name = "prd_id"), inverseJoinColumns = @JoinColumn(name = "cat_id"))
    @ToString.Exclude
    private List<Category> categories;
    @ManyToMany
    @JoinTable(name = "coupon_has_product", joinColumns = @JoinColumn(name = "prd_id"), inverseJoinColumns = @JoinColumn(name = "cpn_id"))
    @ToString.Exclude
    private List<Coupon> applicableCoupons;

    @Override
    public void saveExtraOperations() {
        LocalDateTime now = LocalDateTime.now();
        this.additionDate = now;
        this.lastUpdate = now;
    }

    @Override
    public void beforeUpdate() {
        this.lastUpdate = LocalDateTime.now();
    }
}
