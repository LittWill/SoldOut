package com.wnra.soldout.categoria;

import com.wnra.soldout.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN, imports = {LocalDateTime.class})
public interface CategoryMapper {

    @Mapping(target = "dataAdicao", expression = "java(LocalDateTime.now())")
    Category toModel(FormCategoryDTO formCategoryDTO);
    CategoryResponse toResponse(Category category);

}
