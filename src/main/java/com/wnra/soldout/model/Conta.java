package com.wnra.soldout.model;

import com.wnra.soldout.enums.StatusConta;
import lombok.*;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Conta {

    @Id
    private String id;
    private LocalDateTime dataCriacao;
    private StatusConta statusConta;
    private String senha;

    @Embedded
    private Cliente cliente;

    @OneToMany(mappedBy = "conta")
    private List<Endereco> enderecos;


}
