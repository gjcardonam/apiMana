package com.reposteria.mana.infrastructure.database.adapters;

import com.reposteria.mana.domain.entities.Category;
import com.reposteria.mana.domain.repositories.ICategoryRepository;
import com.reposteria.mana.infrastructure.database.dto.CategoryDTO;
import com.reposteria.mana.infrastructure.database.repositories.ICategoryRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository implements ICategoryRepository {

    private final ICategoryRepositoryJPA categoryRepositoryJPA;

    @Autowired
    public CategoryRepository(ICategoryRepositoryJPA categoryRepositoryJPA) {
        this.categoryRepositoryJPA = categoryRepositoryJPA;
    }

    @Override
    public Category save(Category category) {
        CategoryDTO categoryDTO = CategoryDTO.fromDomainModel(category);
        CategoryDTO savedCategoryDTO = categoryRepositoryJPA.save(categoryDTO);
        return savedCategoryDTO.toDomainModel();
    }

    @Override
    public Optional<Category> findById(Long id) {
        Optional<CategoryDTO> categoryDTO = categoryRepositoryJPA.findById(id);
        return categoryDTO.map(CategoryDTO::toDomainModel);
    }

    @Override
    public List<Category> findAll() {
        List<CategoryDTO> categoryDTOList = categoryRepositoryJPA.findAll();
        return CategoryDTO.toDomainModelList(categoryDTOList);
    }

    @Override
    public void deleteById(Long aLong) {
        categoryRepositoryJPA.deleteById(aLong);
    }

    @Override
    public Optional<Category> update(Long id, Category entity) {
        if (id == null) {
            throw new IllegalArgumentException("Category ID must not be null for update operation");
        }

        CategoryDTO existingCategoryDTO = categoryRepositoryJPA.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        existingCategoryDTO.setName(entity.getName());
        existingCategoryDTO.setDescription(entity.getDescription());

        CategoryDTO updatedCategoryDTO = categoryRepositoryJPA.save(existingCategoryDTO);
        return Optional.ofNullable(updatedCategoryDTO.toDomainModel());
    }

}
