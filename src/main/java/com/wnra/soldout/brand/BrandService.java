package com.wnra.soldout.brand;

import com.wnra.soldout.common.GenericService;
import com.wnra.soldout.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class BrandService extends GenericService<Brand, String> {

    public BrandService(JpaRepository<Brand, String> repository) {
        super(repository);
    }

    public Brand save(Brand brand) {
        LocalDateTime now = LocalDateTime.now();
        brand.setId(UUID.randomUUID().toString());
        brand.setAddDate(now);
        brand.setLastUpdate(now);
        return repository.save(brand);
    }

    public Brand update(String brandId, Brand updatedBrand) {
        Brand oldBrand = findById(brandId).orElseThrow();
        updatedBrand.setId(oldBrand.getId());
        updatedBrand.setAddDate(oldBrand.getAddDate());
        updatedBrand.setLastUpdate(LocalDateTime.now());
        return repository.save(updatedBrand);
    }

}
