package com.wnra.soldout.produto.tipos.tenis;

import com.wnra.soldout.model.Tenis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenisRepository extends JpaRepository<Tenis, String> {

}
