package com.wnra.soldout.model;

import com.wnra.soldout.enums.StatusCompra;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "compra_id", nullable = false)
    private List<ItemCompra> itensCompra;

    @ManyToOne(optional = false)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "cupom_codigo")
    private Cupom cupom;

    public Compra(BigDecimal valorFrete, Conta conta, Endereco endereco, Cupom cupom, List<ItemCompra> itensCompra) {
        this.id = UUID.randomUUID().toString();
        this.dataAdicao = LocalDateTime.now();
        this.statusCompra = StatusCompra.PROCESSAMENTO;
        this.valorFrete = valorFrete;
        this.conta = conta;
        this.endereco = endereco;
        this.cupom = cupom;
        this.itensCompra = itensCompra;
    }


}
