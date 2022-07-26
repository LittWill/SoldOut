package com.wnra.soldout.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Avaliacao {

    @Id
    private String id;
    private LocalDateTime dataAdicao;
    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

}
