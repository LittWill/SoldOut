package com.wnra.soldout.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class TenisEstoque implements Serializable {

    @Column(updatable = false)
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "tenis_id", nullable = false)
    private Tenis tenis;

    @ManyToOne
    @JoinColumn(name = "tamanho_id", nullable = false)
    private Tamanho tamanho;

    @Column(nullable = false)
    private Integer quantidade;

    public TenisEstoque(Tenis tenis, Tamanho tamanho, Integer quantidade){
        this.id = UUID.randomUUID().toString();
        this.tenis = tenis;
        this.tamanho = tamanho;
        this.quantidade = quantidade;
    }

}
