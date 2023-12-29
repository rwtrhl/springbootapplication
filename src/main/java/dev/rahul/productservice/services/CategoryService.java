package dev.rahul.productservice.services;


import dev.rahul.productservice.dtos.CategoryDto;
import dev.rahul.productservice.dtos.FakeStoreProductDto;
import dev.rahul.productservice.dtos.GenericProductDto;
import dev.rahul.productservice.exceptions.NotFoundException;
import dev.rahul.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductServiceClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public interface CategoryService {

    public CategoryDto[] getAllCategories();

    public CategoryDto getCategoryById(String id) throws NotFoundException;

    public CategoryDto createCategory(CategoryDto category);

    public CategoryDto updateProductById(String id, CategoryDto category);

    public CategoryDto deleteCategoryById(String id);

}
