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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "brand")
@EntityListeners(CrudListener.class)
public class Brand implements CrudOperations {

    @Id
    @Column(name = "brd_id")
    private String id;
    @Column(name = "brd_addition_date")
    private LocalDateTime addDate;
    @Column(name = "brd_last_update")
    private LocalDateTime lastUpdate;
    @Column(name = "brd_name")
    private String name;
    @Column(name = "brd_uri_logo")
    private String uriLogo;

    @Override
    public void beforeSave() {
        LocalDateTime now = LocalDateTime.now();
        this.addDate = now;
        this.lastUpdate = now;
    }

    @Override
    public void beforeUpdate() {
        this.lastUpdate = LocalDateTime.now();
    }
}
