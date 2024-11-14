package com.reposteria.mana.application.services;

import com.reposteria.mana.domain.entities.Product;
import com.reposteria.mana.domain.repositories.ICategoryRepository;
import com.reposteria.mana.domain.repositories.IProductRepository;
import com.reposteria.mana.domain.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    private final IProductRepository productRepository;

    @Autowired
    public ProductService(IProductRepository ProductRepository) {
        this.productRepository = ProductRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product Product) {
        return productRepository.save(Product);
    }

    @Override
    public Optional<Product> update(Long id, Product Product) {
        return productRepository.update(id, Product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
