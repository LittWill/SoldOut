package com.wnra.soldout.category;

import com.wnra.soldout.category.dto.RequestCategoryDTO;
import com.wnra.soldout.category.dto.ResponseCategoryDTO;
import com.wnra.soldout.domain.Category;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public interface CategoryMapper {
    Category toModel(RequestCategoryDTO dto);

    ResponseCategoryDTO toResponse(Category category);

    Category toModel1(ResponseCategoryDTO responseCategoryDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Category partialUpdate(ResponseCategoryDTO responseCategoryDTO, @MappingTarget Category category);
}
