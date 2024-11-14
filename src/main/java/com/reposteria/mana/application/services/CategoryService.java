package com.reposteria.mana.application.services;

import com.reposteria.mana.domain.entities.Category;
import com.reposteria.mana.domain.repositories.ICategoryRepository;
import com.reposteria.mana.domain.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    private final ICategoryRepository categoryRepository;

    @Autowired
    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> update(Long id, Category category) {
        return categoryRepository.update(id, category);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
