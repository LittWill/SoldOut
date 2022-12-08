package com.wnra.soldout.domain.crud;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Slf4j
public class CrudListener {
    @PrePersist
    private void beforeSave(CrudOperations crudOperationsImpl) {
        crudOperationsImpl.beforeSave();

    }

    @PreUpdate
    private void beforeUpdate(CrudOperations crudOperations) {
        crudOperations.beforeUpdate();
    }

    @PostPersist
    private void afterSave(CrudOperations crudOperations) {
        log.info("Entidade salva: {}", crudOperations);
    }

    @PostLoad
    private void afterLoad(CrudOperations crudOperations) {
        log.info("Entidade buscada: {}", crudOperations);
    }

    @PostRemove
    private void afterRemove(CrudOperations crudOperations) {
        log.info("Entidade excluída: {}", crudOperations);
    }


}
