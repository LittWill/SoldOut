package com.wnra.soldout.category;

import com.wnra.soldout.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN, imports = {LocalDateTime.class})
public interface CategoryMapper {

    @Mapping(target = "addData", expression = "java(LocalDateTime.now())")
    Category toModel(FormCategoryDTO formCategoryDTO);
    CategoryResponse toResponse(Category category);

}
