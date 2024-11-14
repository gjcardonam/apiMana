package com.reposteria.mana.infrastructure.database.repositories;

import com.reposteria.mana.infrastructure.database.dto.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepositoryJPA extends JpaRepository<ProductDTO, Long> {
}
