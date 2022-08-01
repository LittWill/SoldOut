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
public class Tamanho {

    @Id
    private String tamanho;

    public Tamanho(String tamanho) {
        this.tamanho = tamanho;
    }

}
