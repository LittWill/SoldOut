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
public class ProdutoEstoque implements Serializable {

    @Column(updatable = false)
    @Id
    private String id;

    @OneToOne(optional = false)
    @JoinColumn(name = "produto_id", updatable = false, unique = true)
    private Produto produto;

    @Column(nullable = false)
    private Integer quantidade;

    public ProdutoEstoque (Produto produto, Integer quantidade){
        this.id = UUID.randomUUID().toString();
        this.produto = produto;
        this.quantidade = quantidade;
    }

}
