package com.wnra.soldout.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class ShoeStock implements Serializable {

    @Column(updatable = false)
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "tenis_id", nullable = false)
    private Shoe shoe;

    @ManyToOne
    @JoinColumn(name = "tamanho_id", nullable = false)
    private Size size;

    @Column(nullable = false)
    private Integer amount;

    public ShoeStock(Shoe shoe, Size size, Integer amount){
        this.id = UUID.randomUUID().toString();
        this.shoe = shoe;
        this.size = size;
        this.amount = amount;
    }

}
