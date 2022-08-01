package com.wnra.soldout.repository;

import com.wnra.soldout.model.Tamanho;
import com.wnra.soldout.model.TenisEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoEstoqueRepository extends JpaRepository<TenisEstoque, String> {
    Optional<TenisEstoque> findByTenisIdAndTamanho(String tenisId, Tamanho tamanho);
}
