package com.wnra.soldout.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Size {

    @Id
    private String size;

    public Size(String size) {
        this.size = size;
    }

}
