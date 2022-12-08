package com.wnra.soldout.domain.crud.generator;

import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class IdGenerator {
    public static String generate() {
        return UUID.randomUUID().toString();
    }
}
