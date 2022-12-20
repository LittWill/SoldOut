package com.wnra.soldout.domain;

import com.wnra.soldout.domain.crud.CrudListener;
import com.wnra.soldout.domain.crud.CrudOperations;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SuperBuilder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EntityListeners(CrudListener.class)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "prd_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Product implements CrudOperations {
    @Id
    @Column(name = "prd_id")
    protected String id;
    @Column(name = "prd_addition_date")
    protected LocalDateTime additionDate;
    @Column(name = "prd_last_update")
    protected LocalDateTime lastUpdate;
    @Column(name = "prd_type", insertable = false, updatable = false)
    protected String type;
    @Column(name = "prd_model")
    protected String model;
    @Column(name = "prd_description")
    protected String description;
    @Column(name = "prd_price")
    protected BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "prd_brd_id")
    protected Brand brand;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "prd_prm_id")
    protected Promotion currentPromotion;
    @ManyToMany
    @JoinTable(name = "category_has_product", joinColumns = @JoinColumn(name = "prd_id"), inverseJoinColumns = @JoinColumn(name = "cat_id"))
    @ToString.Exclude
    protected List<Category> categories;
    @ManyToMany
    @JoinTable(name = "coupon_has_product", joinColumns = @JoinColumn(name = "prd_id"), inverseJoinColumns = @JoinColumn(name = "cpn_id"))
    @ToString.Exclude
    protected List<Coupon> applicableCoupons;

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
