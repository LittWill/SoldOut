package com.wnra.soldout.product;

import com.wnra.soldout.brand.BrandMapper;
import com.wnra.soldout.category.CategoryMapper;
import com.wnra.soldout.domain.Brand;
import com.wnra.soldout.domain.Category;
import com.wnra.soldout.domain.Product;
import com.wnra.soldout.domain.ProductConstants;
import com.wnra.soldout.domain.Shoes;
import com.wnra.soldout.product.dto.ResponseProductDTO;
import com.wnra.soldout.product.dto.SaveProductDTO;
import com.wnra.soldout.product.shoes.dto.SaveShoesDTO;
import com.wnra.soldout.promotion.dto.ResponsePromotionProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN, imports = {List.class, Brand.class, Category.class, Collectors.class}, uses = {BrandMapper.class, CategoryMapper.class})
public interface ProductMapper {
    @Mapping(target = "brand", expression = "java(Brand.builder().id(dto.getBrandId()).build())")
    @Mapping(target = "categories", expression = "java(dto.getCategoriesIds().stream().map(categoryId -> Category.builder().id(categoryId).build()).collect(Collectors.toList()))")
    Shoes toModel(SaveShoesDTO dto);

    @Mapping(target = "brand", expression = "java(Brand.builder().id(dto.getBrandId()).build())")
    @Mapping(target = "categories", expression = "java(dto.getCategoriesIds().stream().map(categoryId -> Category.builder().id(categoryId).build()).collect(Collectors.toList()))")
    Shoes toModel(SaveProductDTO dto);

    ResponsePromotionProductDTO toPromotionResponse(Product product);

    ResponseProductDTO toResponse(Product product);
}
