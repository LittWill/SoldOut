package com.wnra.soldout.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class ProdutoEstoque implements Serializable {

    @Id
    @OneToOne(optional = false)
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;
    private Integer quantidade;

}
