package com.wnra.soldout.domain.crud;

import com.wnra.soldout.domain.crud.generator.IdGenerator;

import javax.persistence.Id;
import java.util.Arrays;

public interface CrudOperations {

    default void beforeSave() {
        generateId(this);
        saveExtraOperations();
    }

    default void saveExtraOperations() {
    }

    default void beforeUpdate() {
    }

    private void generateId(CrudOperations crudOperationsImpl) {
        Arrays.stream(crudOperationsImpl.getClass().getDeclaredFields())
                .filter(declaredField -> declaredField.isAnnotationPresent(Id.class))
                .findAny()
                .ifPresent(declaredField -> {
                    try {
                        declaredField.setAccessible(true);
                        declaredField.set(crudOperationsImpl, IdGenerator.generate());
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                });
    }


}
