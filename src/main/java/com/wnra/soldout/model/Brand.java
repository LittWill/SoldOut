package com.wnra.soldout.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "brands")
public class Brand {

    @Id
    @Column(updatable = false)
    private String id;

    @Column(nullable = false, updatable = false)
    private LocalDateTime addDate;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<BrandImage> brandImages;

    public Brand(String nome) {
        this.id = UUID.randomUUID().toString();
        this.addDate = LocalDateTime.now();
        this.name = nome;
    }

}
