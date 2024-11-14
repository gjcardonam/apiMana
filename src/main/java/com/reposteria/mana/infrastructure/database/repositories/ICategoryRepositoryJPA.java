package com.reposteria.mana.infrastructure.database.repositories;

import com.reposteria.mana.infrastructure.database.dto.CategoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepositoryJPA extends JpaRepository<CategoryDTO, Long> {
}
