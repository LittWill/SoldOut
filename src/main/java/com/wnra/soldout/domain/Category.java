package com.wnra.soldout.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Category {

    @Id
    private String id;
    private LocalDateTime lastUpdate;
    private LocalDateTime additionDate;
    private String name;
    private String description;

}
