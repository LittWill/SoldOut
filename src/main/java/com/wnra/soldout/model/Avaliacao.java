package com.wnra.soldout.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Avaliacao {

    @Id
    @Column(updatable = false)
    private String id;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataAdicao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "conta_id", updatable = false)
    private Conta conta;
    @ManyToOne(optional = false)
    @JoinColumn(name = "produto_id", updatable = false)
    private Produto produto;

}
