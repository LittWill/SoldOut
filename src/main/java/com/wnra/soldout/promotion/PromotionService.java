package com.wnra.soldout.promotion;

import com.wnra.soldout.common.GenericService;
import com.wnra.soldout.domain.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public class PromotionService extends GenericService<Promotion, String> {
    public PromotionService(JpaRepository<Promotion, String> repository) {
        super(repository);
    }
}
