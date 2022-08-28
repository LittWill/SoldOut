package com.wnra.soldout.produto.tipos.tenis.tamanho;

import com.wnra.soldout.model.Tamanho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TamanhoRepository extends JpaRepository<Tamanho, String> {
}
