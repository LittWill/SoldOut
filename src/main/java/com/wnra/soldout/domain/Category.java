package com.wnra.soldout.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "category")
public class Category {

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

}
