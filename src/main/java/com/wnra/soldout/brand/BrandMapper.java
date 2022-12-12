package com.wnra.soldout.brand;

import com.wnra.soldout.brand.dto.RequestBrandDTO;
import com.wnra.soldout.brand.dto.ResponseBrandDTO;
import com.wnra.soldout.domain.Brand;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public interface BrandMapper {

    Brand toModel(RequestBrandDTO dto);

    ResponseBrandDTO toResponse(Brand brand);

    Brand toEntity(ResponseBrandDTO responseBrandDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Brand partialUpdate(ResponseBrandDTO responseBrandDTO, @MappingTarget Brand brand);
}
