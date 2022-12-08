package com.wnra.soldout.domain;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Slf4j
public class CallBackListener {
    @PrePersist
    public void beforeSave(DefaultOperations defaultOperations) {
        defaultOperations.beforeSave();

    }

    @PreUpdate
    public void beforeUpdate(DefaultOperations defaultOperations) {
        defaultOperations.beforeUpdate();
    }

    @PostPersist
    public void afterSave(DefaultOperations defaultOperations) {
        log.info("Entidade salva: {}", defaultOperations);
    }

    @PostLoad
    public void afterLoad(DefaultOperations defaultOperations) {
        log.info("Entidade buscada: {}", defaultOperations);
    }

    @PostRemove
    public void afterRemove(DefaultOperations defaultOperations) {
        log.info("Entidade excluída: {}", defaultOperations);
    }
}
