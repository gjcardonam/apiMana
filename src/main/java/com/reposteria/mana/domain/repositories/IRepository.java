package com.reposteria.mana.domain.repositories;

import java.util.List;
import java.util.Optional;

public interface IRepository<T, ID> {
    T save(T entity);
    Optional<T> findById(ID id);
    List<T> findAll();
    void deleteById(ID id);
    Optional<T> update(ID id, T entity);
}
