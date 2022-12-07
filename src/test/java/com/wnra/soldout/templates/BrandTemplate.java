package com.wnra.soldout.templates;

import com.wnra.soldout.brand.dto.RequestBrandDTO;
import com.wnra.soldout.domain.Brand;

public class BrandTemplate {

    public static Brand getValid(){
       return Brand.builder()
               .name("BRAND_NAME")
               .uriLogo("URI_LOGO")
               .build();
    }

    public static RequestBrandDTO getValidRequestDTO(){
        return RequestBrandDTO.builder()
                .name("BRAND_NAME")
                .uriLogo("URI_LOGO")
                .build();
    }
}
