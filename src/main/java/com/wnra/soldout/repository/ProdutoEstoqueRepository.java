package com.wnra.soldout.repository;

import com.wnra.soldout.model.Categoria;
import com.wnra.soldout.model.Produto;
import com.wnra.soldout.model.ProdutoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoEstoqueRepository extends JpaRepository<ProdutoEstoque, String> {

    Optional<ProdutoEstoque> findByProdutoId(String produtoId);

}
