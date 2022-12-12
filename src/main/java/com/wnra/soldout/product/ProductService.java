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

    public Product update(String id, Product updatedProduct) {
        Product oldProduct = findById(id).orElseThrow();
        updatedProduct.setId(oldProduct.getId());
        updatedProduct.setAdditionDate(oldProduct.getAdditionDate());
        updatedProduct.setCurrentPromotion(oldProduct.getCurrentPromotion());
        return repository.save(updatedProduct);
    }
}
