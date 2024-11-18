package com.reposteria.mana.infrastructure.web;

import com.reposteria.mana.domain.entities.Product;
import com.reposteria.mana.domain.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final IProductService ProductService;

    @Autowired
    public ProductController(IProductService ProductService) {
        this.ProductService = ProductService;
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Product>> getCategories() {
        return ResponseEntity.ok(ProductService.findAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        return ProductService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Product> saveProduct(@RequestBody Product Product) {
        return ResponseEntity.ok(ProductService.save(Product));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product Product) {
        return ProductService.update(id, Product).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public void deleteProduct(@PathVariable Long id) {
        ProductService.delete(id);
    }
}
