package com.wnra.soldout.brand;

import com.wnra.soldout.domain.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;

    public Brand save(Brand brand) {
        brand.setId(UUID.randomUUID().toString());
        brand.setAddDate(LocalDateTime.now());
        return brandRepository.save(brand);
    }

    public Brand find(String id) {
        return brandRepository.findById(id).orElseThrow();
    }

    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    public Brand update(String brandId, Brand updatedBrand) {
        Brand oldBrand = find(brandId);
        updatedBrand.setId(oldBrand.getId());
        updatedBrand.setAddDate(oldBrand.getAddDate());
        return updatedBrand;
    }

    public void delete(String brandId) {
        brandRepository.delete(find(brandId));
    }

}
