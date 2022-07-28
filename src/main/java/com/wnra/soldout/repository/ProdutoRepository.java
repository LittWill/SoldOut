package com.wnra.soldout.repository;

import com.wnra.soldout.model.Produto;
import com.wnra.soldout.model.Promocao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, String> {
    List<Produto> findByPromocao(Promocao promocao);
}
