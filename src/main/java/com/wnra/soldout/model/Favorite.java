package com.wnra.soldout.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Favorite {

    @Id
    @Column(updatable = false)
    private String id;

    @Column(nullable = false, updatable = false)
    private LocalDateTime addDate;

    @ManyToOne(optional = false)
    @JoinColumn(updatable = false, unique = true)
    private Product product;

    @ManyToOne(optional = false)
    @JoinColumn(updatable = false, nullable = false)
    @JsonIgnore
    private Account account;

    public Favorite(Product product, Account account) {
        this.id = UUID.randomUUID().toString();
        this.addDate = LocalDateTime.now();
        this.product = product;
        this.account = account;
    }

}
