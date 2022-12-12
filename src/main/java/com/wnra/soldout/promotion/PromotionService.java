package com.wnra.soldout.promotion;

import com.wnra.soldout.common.GenericService;
import com.wnra.soldout.domain.Product;
import com.wnra.soldout.domain.Promotion;
import com.wnra.soldout.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PromotionService extends GenericService<Promotion, String> {
    @Autowired
    private ProductRepository productRepository;

    public PromotionService(JpaRepository<Promotion, String> repository) {
        super(repository);
    }

    @Override
    public Promotion save(Promotion promotion) {
        verifyProducts(promotion.getProducts());
        return repository.save(promotion);
    }

    public Promotion assignPromotion(Promotion promotion) {
        promotion = findById(promotion.getId()).orElseThrow();
        verifyProducts(promotion.getProducts());
        promotion.setProducts(promotion.getProducts());
        return repository.save(promotion);
    }

    public Promotion updatePromotion(String id, Promotion updatedPromotion) {
        Promotion oldPromotion = findById(id).orElseThrow();
        updatedPromotion.setId(id);
        updatedPromotion.setCreationDate(oldPromotion.getCreationDate());
        return repository.save(updatedPromotion);
    }

    private void verifyProducts(List<Product> products) {
        boolean isAllProductsFound = products.stream()
                .map(Product::getId)
                .allMatch(productRepository::existsById);

        if (isAllProductsFound) {
            throw new EntityNotFoundException("Um ou mais produtos não encontrados!");
        }
    }
}
