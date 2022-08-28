package com.wnra.soldout.model;

import com.wnra.soldout.conta.StatusConta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Conta {

    @Id
    @Column(updatable = false)
    private String id;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @Column(nullable = false)
    private StatusConta statusConta;

    @Column(nullable = false)
    private String senha;

    @Embedded
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "conta_id")
    private List<Endereco> enderecos;

    @OneToMany(mappedBy = "conta")
    private List<Favorito> favoritos;

    @OneToMany(mappedBy = "conta")
    private List<Compra> compras;

    @ManyToMany
    private List<Cupom> cupons;

    public Conta(Cliente cliente, String senha) {
        this.id = UUID.randomUUID().toString();
        this.dataCriacao = LocalDateTime.now();
        this.cliente = cliente;
        this.senha = senha;
        this.statusConta = StatusConta.INATIVA;
    }


}
