package com.wnra.soldout.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class GenericService<T, ID>  {

    @Autowired
    protected JpaRepository<T, ID> repository;

    public T save(T t){
        return repository.save(t);
    }

    public T get(ID id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Entidade não encontrada"));
    }

    public Page<T> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public void delete(ID id){
        T t = this.get(id);
        repository.delete(t);
    }

}
