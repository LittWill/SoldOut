package com.wnra.soldout.model;

import com.wnra.soldout.enums.StatusCompra;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Compra {

    @Id
    private String id;
    private LocalDateTime dataAdicao;
    private StatusCompra statusCompra;
    private BigDecimal valorFrete;
    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;
    @ManyToOne
    @JoinColumn(name = "endereco_cep")
    private Endereco endereco;
    @ManyToOne
    @JoinColumn(name = "cupom_codigo")
    private Cupom cupom;
    @ManyToOne
    @JoinColumn(name = "promocao_id")
    private Promocao promocao;


}
