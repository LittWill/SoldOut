package com.wnra.soldout.domain.crud;

public interface CrudOperations {

    default void beforeSave() {
    }

    default void beforeUpdate() {
    }

}
