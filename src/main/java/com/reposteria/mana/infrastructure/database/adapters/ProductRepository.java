package com.reposteria.mana.infrastructure.database.adapters;

import com.reposteria.mana.domain.entities.Product;
import com.reposteria.mana.domain.repositories.IProductRepository;
import com.reposteria.mana.infrastructure.database.dto.CategoryDTO;
import com.reposteria.mana.infrastructure.database.dto.ProductDTO;
import com.reposteria.mana.infrastructure.database.repositories.IProductRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements IProductRepository {

    private final IProductRepositoryJPA productRepositoryJPA;

    @Autowired
    public ProductRepository(IProductRepositoryJPA productRepositoryJPA) {
        this.productRepositoryJPA = productRepositoryJPA;
    }

    @Override
    public Product save(Product product) {
        ProductDTO productDTO = ProductDTO.fromDomainModel(product);
        ProductDTO savedProductDTO = productRepositoryJPA.save(productDTO);
        return savedProductDTO.toDomainModel();
    }

    @Override
    public Optional<Product> findById(Long id) {
        Optional<ProductDTO> productDTO = productRepositoryJPA.findById(id);
        return productDTO.map(ProductDTO::toDomainModel);
    }

    @Override
    public List<Product> findAll() {
        List<ProductDTO> productDTOList = productRepositoryJPA.findAll();
        return ProductDTO.toDomainModelList(productDTOList);
    }

    @Override
    public void deleteById(Long id) {
        productRepositoryJPA.deleteById(id);
    }

    @Override
    public Optional<Product> update(Long id, Product product) {
        if (id == null) {
            throw new IllegalArgumentException("Product ID must not be null for update operation");
        }

        ProductDTO existingProductDTO = productRepositoryJPA.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        existingProductDTO.setName(product.getName());
        existingProductDTO.setDescription(product.getDescription());
        existingProductDTO.setPrice(product.getPrice());
        existingProductDTO.setCategoryDTO(CategoryDTO.fromDomainModel(product.getCategory()));
        existingProductDTO.setStockQuantity(product.getStockQuantity());

        ProductDTO updatedProductDTO = productRepositoryJPA.save(existingProductDTO);
        return Optional.ofNullable(updatedProductDTO.toDomainModel());
    }
}
