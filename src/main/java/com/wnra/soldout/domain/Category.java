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
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "category")
@EntityListeners(CrudListener.class)
public class Category implements CrudOperations {

    @Id
    @Column(name = "cat_id")
    private String id;
    @Column(name = "cat_addition_date")
    private LocalDateTime additionDate;
    @Column(name = "cat_last_update")
    private LocalDateTime lastUpdate;
    @Column(name = "cat_name")
    private String name;
    @Column(name = "cat_description")
    private String description;

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
