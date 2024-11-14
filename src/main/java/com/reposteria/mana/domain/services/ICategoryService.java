package com.reposteria.mana.domain.services;

import com.reposteria.mana.domain.entities.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    Category save(Category category);
    Optional<Category> update(Long id, Category category);
    Optional<Category> findById(Long id);
    List<Category> findAll();
    void delete(Long id);
}