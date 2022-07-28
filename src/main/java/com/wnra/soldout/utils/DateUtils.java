package com.wnra.soldout.utils;

import java.time.LocalDateTime;

public class DateUtils {

    public static boolean isDataExpirada(LocalDateTime dataExpiracao){
        return dataExpiracao.isBefore(LocalDateTime.now());
    }
}
