package com.reposteria.mana.infrastructure.database.dto;


import com.reposteria.mana.domain.entities.Category;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "Categories")
@Data
public class CategoryDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    public CategoryDTO() {
    }

    public CategoryDTO(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static CategoryDTO fromDomainModel(Category category) {
        return new CategoryDTO(category.getId(), category.getName(), category.getDescription());
    }

    public static List<Category> toDomainModelList(List<CategoryDTO> categoryDTOList) {
        return categoryDTOList.stream()
                .map(dto -> new Category(dto.getId(), dto.getName(), dto.getDescription()))
                .collect(Collectors.toList());
    }

    public Category toDomainModel() {
        return new Category(this.id, this.name, this.description);
    }
}
