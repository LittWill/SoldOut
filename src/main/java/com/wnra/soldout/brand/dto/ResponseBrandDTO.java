package com.wnra.soldout.brand.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResponseBrandDTO {

    private String name;
    private LocalDateTime addDate;
}
