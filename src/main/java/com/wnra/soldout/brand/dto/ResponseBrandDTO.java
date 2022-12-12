package com.wnra.soldout.brand.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseBrandDTO {

    private String name;
    private LocalDateTime addDate;
}
