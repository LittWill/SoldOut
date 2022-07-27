package com.wnra.soldout.model;

import com.wnra.soldout.enums.StatusCompra;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Compra {

    @Id
    @Column(updatable = false)
    private String id;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataAdicao;

    @Column(nullable = false)
    private StatusCompra statusCompra;

    @Column(nullable = false)
    private BigDecimal valorFrete;

    @ManyToOne(optional = false)
    @JoinColumn(name = "conta_id", updatable = false)
    private Conta conta;

    @ManyToOne(optional = false)
    @JoinColumn(name = "endereco_cep")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "cupom_codigo")
    private Cupom cupom;

    @OneToMany
    private List<Promocao> promocoesUtilizadas;


}
