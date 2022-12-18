package com.wnra.soldout.promotion;

import com.wnra.soldout.common.GenericService;
import com.wnra.soldout.domain.Product;
import com.wnra.soldout.domain.Promotion;
import com.wnra.soldout.product.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class PromotionService extends GenericService<Promotion, String> {
    private final ProductRepository productRepository;

    public PromotionService(JpaRepository<Promotion, String> repository, ProductRepository productRepository) {
        super(repository);
        this.productRepository = productRepository;
    }

    @Override
    public Promotion save(Promotion promotion) {
        verifyProducts(promotion.getProducts());
        return repository.save(promotion);
    }

    public Promotion updatePromotion(String id, Promotion updatedPromotion) {
        Promotion oldPromotion = findById(id).orElseThrow();
        updatedPromotion.setId(id);
        updatedPromotion.setCreationDate(oldPromotion.getCreationDate());
        verifyProducts(updatedPromotion.getProducts());
        return repository.save(updatedPromotion);
    }

    @Override
    public void deleteById(String id) {
        repository.delete(findById(id).orElseThrow());
    }

    private void verifyProducts(List<Product> products) {
        if (!CollectionUtils.isEmpty(products)) {
            List<String> productsIdsNotFound = products.stream()
                    .map(Product::getId)
                    .filter(Predicate.not(productRepository::existsById))
                    .collect(Collectors.toList());

            if (!productsIdsNotFound.isEmpty()) {
                throw new EntityNotFoundException("Um ou mais produtos não encontrados! " + productsIdsNotFound);
            }
        }
    }
}
