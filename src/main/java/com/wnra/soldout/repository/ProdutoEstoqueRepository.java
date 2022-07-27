package com.wnra.soldout.repository;

import com.wnra.soldout.model.Categoria;
import com.wnra.soldout.model.Produto;
import com.wnra.soldout.model.ProdutoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoEstoqueRepository extends JpaRepository<ProdutoEstoque, String> {
}
