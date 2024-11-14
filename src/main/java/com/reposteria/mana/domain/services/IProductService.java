package com.reposteria.mana.domain.services;

import com.reposteria.mana.domain.entities.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    Product save(Product Product);
    Optional<Product> update(Long id, Product Product);
    Optional<Product> findById(Long id);
    List<Product> findAll();
    void delete(Long id);
}