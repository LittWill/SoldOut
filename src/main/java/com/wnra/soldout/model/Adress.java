package com.wnra.soldout.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Adress {

    @Id
    @Column(updatable = false)
    private String id;

    @Column(nullable = false)
    private String zipCode;

    @Column(nullable = false, updatable = false)
    private String name;

    @Column(nullable = false, updatable = false)
    private String number;

    public Adress(){
        this.id = UUID.randomUUID().toString();
    }

    public Adress(String zipCode, String name, String number) {
        this.id = UUID.randomUUID().toString();
        this.zipCode = zipCode;
        this.name = name;
        this.number = number;
    }

}
