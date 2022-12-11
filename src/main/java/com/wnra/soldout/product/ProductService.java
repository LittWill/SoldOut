package com.wnra.soldout.product;

import com.wnra.soldout.common.GenericService;
import com.wnra.soldout.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends GenericService<Product, String> {
    public ProductService(JpaRepository<Product, String> repository) {
        super(repository);
    }
}
