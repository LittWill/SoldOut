package com.wnra.soldout.produto;

import com.wnra.soldout.model.Product;
import com.wnra.soldout.model.Promocao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Product, String> {
    List<Product> findByPromotion(Promocao promotion);
}
