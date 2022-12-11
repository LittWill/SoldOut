package com.wnra.soldout.product;

import com.wnra.soldout.domain.Brand;
import com.wnra.soldout.domain.Category;
import com.wnra.soldout.domain.Product;
import com.wnra.soldout.product.dto.RequestProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN, imports = {List.class, Brand.class, Category.class, Collectors.class})
public interface ProductMapper {

    @Mapping(target = "brand", expression = "java(Brand.builder().id(dto.getBrandId()).build())")
    @Mapping(target = "categories", expression = "java(dto.getCategoriesIds().stream().map(categoryId -> Category.builder().id(categoryId).build()).collect(Collectors.toList()))")
    Product toModel(RequestProductDTO dto);
}
