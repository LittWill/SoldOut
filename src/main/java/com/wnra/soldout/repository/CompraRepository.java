package com.wnra.soldout.repository;

import com.wnra.soldout.model.Categoria;
import com.wnra.soldout.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, String> {
}
