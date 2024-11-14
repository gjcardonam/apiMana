package com.reposteria.mana.infrastructure.web;

import com.reposteria.mana.domain.entities.Product;
import com.reposteria.mana.domain.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final IProductService ProductService;

    @Autowired
    public ProductController(IProductService ProductService) {
        this.ProductService = ProductService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getCategories() {
        return ResponseEntity.ok(ProductService.findAll());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        return ProductService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/products")
    public ResponseEntity<Product> saveProduct(@RequestBody Product Product) {
        return ResponseEntity.ok(ProductService.save(Product));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product Product) {
        return ProductService.update(id, Product).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        ProductService.delete(id);
    }
}
