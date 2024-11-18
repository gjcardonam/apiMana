    package com.reposteria.mana.infrastructure.web;

    import com.reposteria.mana.domain.entities.Category;
    import com.reposteria.mana.domain.services.ICategoryService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.security.access.prepost.PreAuthorize;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Optional;

    @RestController
    @RequestMapping("/api/categories")
    public class CategoryController {
        private final ICategoryService categoryService;

        @Autowired
        public CategoryController(ICategoryService categoryService) {
            this.categoryService = categoryService;
        }

        @GetMapping
        @PreAuthorize("hasRole('USER')")
        public ResponseEntity<List<Category>> getCategories() {
            List<Category> categories = categoryService.findAll();
            return ResponseEntity.ok(categories);
        }

        @GetMapping("/{id}")
        @PreAuthorize("hasRole('USER')")
        public ResponseEntity<Category> getCategory(@PathVariable Long id) {
            Category category = categoryService.findById(id).orElse(null);
            return ResponseEntity.ok(category);
        }

        @PostMapping
        @PreAuthorize("hasRole('USER')")
        public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
            Category savedCategory = categoryService.save(category);
            return ResponseEntity.ok(savedCategory);
        }

        @PutMapping("/{id}")
        @PreAuthorize("hasRole('USER')")
        public Optional<ResponseEntity<Category>> updateCategory(@PathVariable Long id, @RequestBody Category category) {
            return categoryService.update(id, category).map(ResponseEntity::ok);
        }

        @DeleteMapping("/{id}")
        @PreAuthorize("hasRole('USER')")
        public void deleteCategory(@PathVariable Long id) {
            categoryService.delete(id);
        }
    }
