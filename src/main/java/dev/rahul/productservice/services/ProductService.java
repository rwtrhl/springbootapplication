package dev.rahul.productservice.services;

import dev.rahul.productservice.dtos.GenericProductDto;
import dev.rahul.productservice.exceptions.NotFoundException;
import dev.rahul.productservice.models.Product;

import java.util.List;

public interface ProductService {
    GenericProductDto getProductById(String id) throws NotFoundException;

    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto updateProductById(String id, GenericProductDto product) throws NotFoundException;

    List<GenericProductDto> getAllProducts();

    GenericProductDto deleteProductById(String id) throws NotFoundException;
}
