package com.wnra.soldout.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Category {

    @Id
    @Column(length = 50, updatable = false)
    private String name;
    @Column(nullable = false, updatable = false)
    private LocalDateTime addData;

}
