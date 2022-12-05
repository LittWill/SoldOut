package com.wnra.soldout.category;

import com.wnra.soldout.category.dto.RequestCategoryDTO;
import com.wnra.soldout.category.dto.ResponseCategoryDTO;
import com.wnra.soldout.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public interface CategoryMapper {
    Category toModel(RequestCategoryDTO dto);

    ResponseCategoryDTO toResponse(Category category);
}
