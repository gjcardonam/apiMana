package com.reposteria.mana.infrastructure.database.dto;

import com.reposteria.mana.domain.entities.Product;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "Products")
@Data
public class ProductDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private CategoryDTO categoryDTO;
    private Integer stockQuantity;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, String description, Double price, CategoryDTO categoryDTO, Integer stockQuantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryDTO = categoryDTO;
        this.stockQuantity = stockQuantity;
    }

    public static ProductDTO fromDomainModel(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice(), CategoryDTO.fromDomainModel(product.getCategory()), product.getStockQuantity());
    }

    public static List<Product> toDomainModelList(List<ProductDTO> productDTOList) {
        return productDTOList.stream()
                .map(ProductDTO::toDomainModel)
                .collect(Collectors.toList());
    }

    public Product toDomainModel() {
        return new Product(this.id, this.name, this.description, this.price, this.categoryDTO.toDomainModel(), this.stockQuantity);
    }
}
