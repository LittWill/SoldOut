package com.wnra.soldout.product.shoes.dto;

import com.wnra.soldout.product.dto.SaveProductDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Data
public class SaveShoesDTO extends SaveProductDTO {
    private String shoesAttribute;
}
