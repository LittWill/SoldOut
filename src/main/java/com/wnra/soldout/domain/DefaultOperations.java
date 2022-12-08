package com.wnra.soldout.domain;

public interface DefaultOperations {

    void beforeSave();

    default void beforeUpdate() {

    }

}
