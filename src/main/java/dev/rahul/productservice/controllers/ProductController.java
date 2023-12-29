package dev.rahul.productservice.controllers;


import dev.rahul.productservice.dtos.ExceptionDto;
import dev.rahul.productservice.dtos.GenericProductDto;
import dev.rahul.productservice.exceptions.NotFoundException;
import dev.rahul.productservice.models.Product;
import dev.rahul.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@Primary
@RestController
@RequestMapping("products")
public class ProductController {
//    Field Injection ( Not Recommended)
//    @Autowired
    private ProductService productService;

//     Setter Injection (Not Recommended)
//    public void setProductService(ProductService productService){
//        this.productService = productService;
//    }

    // Constructor Injection (Recommended)
    public ProductController(@Qualifier("SelfProductServiceImpl") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public ResponseEntity<List<GenericProductDto>> getAllProducts(){
        return new ResponseEntity<>(
                productService.getAllProducts(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericProductDto> getProductById(@PathVariable("id") String id)  throws NotFoundException {
        return new ResponseEntity<>(
                productService.getProductById(id),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") String id) throws NotFoundException{
        return new ResponseEntity<>(
                productService.deleteProductById(id),
                HttpStatus.OK
        );
    }
    @PostMapping("")
    public ResponseEntity<GenericProductDto> createProduct(@RequestBody GenericProductDto product){
        return new ResponseEntity<>(
                productService.createProduct(product),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericProductDto> updateProductById(@PathVariable("id") String id, @RequestBody GenericProductDto product) throws NotFoundException{
        return new ResponseEntity<>(
                productService.updateProductById(id, product),
                HttpStatus.OK
        );
    }

}
