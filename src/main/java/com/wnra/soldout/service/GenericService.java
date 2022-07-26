package com.wnra.soldout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class GenericService<T, ID>  {

    @Autowired
    protected JpaRepository<T, ID> repository;

    public T salvar(T t){
        return repository.save(t);
    }

    public T obter(ID id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Entidade não encontrada"));
    }

    public Page<T> listar(Pageable pageable){
        return repository.findAll(pageable);
    }

    public void excluir(ID id){
        T t = this.obter(id);
        repository.delete(t);
    }

}
