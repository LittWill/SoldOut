package com.wnra.soldout.domain;

import com.wnra.soldout.domain.crud.CrudListener;
import com.wnra.soldout.domain.crud.CrudOperations;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "account")
@EntityListeners(CrudListener.class)
public class Account implements CrudOperations {
    @Id
    @Column(name = "acc_id")
    private String id;
    @Column(name = "acc_creation_date")
    private LocalDateTime creationDate;
    @Column(name = "acc_password")
    private String password;
    @Embedded
    private Customer customer;
    @OneToMany(mappedBy = "account")
    @ToString.Exclude
    private List<AssignedCoupon> assignedCoupons;

    @Override
    public void saveExtraOperations() {
        this.creationDate = LocalDateTime.now();
    }
}
