package com.wnra.soldout.promotion;

import com.wnra.soldout.domain.Product;
import com.wnra.soldout.domain.Promotion;
import com.wnra.soldout.product.ProductMapper;
import com.wnra.soldout.promotion.dto.AssignPromotionDTO;
import com.wnra.soldout.promotion.dto.ResponsePromotionDTO;
import com.wnra.soldout.promotion.dto.SavePromotionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN, imports = {Product.class, List.class, Collectors.class}, uses = {ProductMapper.class})
public interface PromotionMapper {

    @Mapping(target = "products", expression = "java(toProducts(dto.getProductsIds()))")
    Promotion toModel(SavePromotionDTO dto);

    @Mapping(target = "products", expression = "java(toProducts(dto.getProductsIds()))")
    @Mapping(source = "promotionId", target = "id")
    Promotion toModel(AssignPromotionDTO dto);

    ResponsePromotionDTO toResponse(Promotion promotion);

    default List<Product> toProducts(List<String> productsIds) {
        return Optional.ofNullable(productsIds).orElseGet(Collections::emptyList)
                .stream()
                .map(id -> Product.builder().id(id).build())
                .collect(Collectors.toList());
    }
}
