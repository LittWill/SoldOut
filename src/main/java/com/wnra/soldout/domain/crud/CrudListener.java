package com.wnra.soldout.domain.crud;

import com.wnra.soldout.domain.crud.generator.IdGenerator;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Arrays;

@Slf4j
public class CrudListener {
    @PrePersist
    public void beforeSave(CrudOperations crudOperationsImpl) {
        generateId(crudOperationsImpl);
        crudOperationsImpl.beforeSave();

    }

    @PreUpdate
    public void beforeUpdate(CrudOperations crudOperations) {
        crudOperations.beforeUpdate();
    }

    @PostPersist
    public void afterSave(CrudOperations crudOperations) {
        log.info("Entidade salva: {}", crudOperations);
    }

    @PostLoad
    public void afterLoad(CrudOperations crudOperations) {
        log.info("Entidade buscada: {}", crudOperations);
    }

    @PostRemove
    public void afterRemove(CrudOperations crudOperations) {
        log.info("Entidade excluída: {}", crudOperations);
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
