package com.wnra.soldout.promotion;

import com.wnra.soldout.common.GenericService;
import com.wnra.soldout.domain.Product;
import com.wnra.soldout.domain.Promotion;
import com.wnra.soldout.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class PromotionService extends GenericService<Promotion, String> {
    @Autowired
    private ProductRepository productRepository;

    public PromotionService(JpaRepository<Promotion, String> repository) {
        super(repository);
    }

    @Override
    public Promotion save(Promotion promotion) {

        boolean allProductsFound = promotion.getProducts().stream()
                .map(Product::getId)
                .allMatch(productRepository::existsById);

        if (!allProductsFound) {
            throw new EntityNotFoundException("Um ou mais produtos não encontrados!");
        }

        return repository.save(promotion);
    }

    public Promotion assignPromotion(Promotion promotion) {
        promotion = findById(promotion.getId()).orElseThrow();

        boolean allProductsFound = promotion.getProducts().stream()
                .map(Product::getId)
                .allMatch(productRepository::existsById);

        if (!allProductsFound) {
            throw new EntityNotFoundException("Um ou mais produtos não encontrados!");
        }

        promotion.setProducts(promotion.getProducts());

        return repository.save(promotion);
    }
}
