package com.wnra.soldout.common;

import com.wnra.soldout.domain.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public abstract class GenericService<T, ID> {
    protected final JpaRepository<T, ID> repository;

    public T save(T t) {
        return repository.save(t);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    public void deleteById(ID id) {
        repository.delete(findById(id).orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada!")));
    }


}
