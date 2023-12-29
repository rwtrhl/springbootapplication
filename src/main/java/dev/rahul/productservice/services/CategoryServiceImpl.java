package dev.rahul.productservice.services;

import dev.rahul.productservice.dtos.CategoryDto;
import dev.rahul.productservice.exceptions.NotFoundException;
import dev.rahul.productservice.models.Category;
import dev.rahul.productservice.models.Product;
import dev.rahul.productservice.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService{
    CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    private CategoryDto ConvertCategoryToCategoryDto(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        return categoryDto;
    }

    public CategoryDto[] getAllCategories(){
        return null;
    }

    public CategoryDto getCategoryById(String id) throws NotFoundException {
        Optional<Category> categoryOption = categoryRepository.findById(UUID.fromString(id));
        if(categoryOption.isEmpty()){
            throw new NotFoundException("Category with id " + id + " not found.");
        }
        Category category = categoryOption.get();
        List<Product> products = category.getProducts();
        CategoryDto categoryDto = ConvertCategoryToCategoryDto(category);
        return categoryDto;
    }

    public CategoryDto createCategory(CategoryDto category){
        return null;
    }

    public CategoryDto updateProductById(String id, CategoryDto category){
        return null;
    }

    public CategoryDto deleteCategoryById(String id){
        return null;
    }
}
