package com.wnra.soldout.templates;

import com.wnra.soldout.category.dto.RequestCategoryDTO;
import com.wnra.soldout.domain.Category;

public class CategoryTemplate {

    public static Category getValid() {
        return Category.builder()
                .name("CATEGORY_NAME")
                .description("CATEGORY_DESCRIPTION").build();
    }

    public static RequestCategoryDTO getValidRequestDTO() {
        return RequestCategoryDTO.builder()
                .name("CATEGORY_NAME")
                .description("CATEGORY_DESCRIPTION")
                .build();
    }
}
