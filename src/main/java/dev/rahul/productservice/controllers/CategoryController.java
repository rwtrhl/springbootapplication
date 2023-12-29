package dev.rahul.productservice.controllers;

import dev.rahul.productservice.dtos.CategoryDto;
import dev.rahul.productservice.exceptions.NotFoundException;
import dev.rahul.productservice.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("categories")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public ResponseEntity<CategoryDto[]> getAllProducts(){
        return new ResponseEntity<>(
                categoryService.getAllCategories(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getProductById(@PathVariable("id") String id)  throws NotFoundException {
        return new ResponseEntity<>(
                categoryService.getCategoryById(id),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryDto> deleteProductById(@PathVariable("id") String id){
        return new ResponseEntity<>(
                categoryService.deleteCategoryById(id),
                HttpStatus.OK
        );
    }
    @PostMapping("")
    public ResponseEntity<CategoryDto> createProduct(@RequestBody CategoryDto category){
        return new ResponseEntity<>(
                categoryService.createCategory(category),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateProductById(@PathVariable("id") String id, @RequestBody CategoryDto category){
        return new ResponseEntity<>(
                categoryService.updateProductById(id, category),
                HttpStatus.OK
        );
    }
}
