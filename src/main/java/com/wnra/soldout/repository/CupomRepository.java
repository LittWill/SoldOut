package com.wnra.soldout.repository;

import com.wnra.soldout.model.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CupomRepository extends JpaRepository<Cupom, String> {

    Optional<Cupom> findByCodigo(String codigo);

}
