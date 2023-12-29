package dev.rahul.productservice.services;

import dev.rahul.productservice.dtos.FakeStoreProductDto;
import dev.rahul.productservice.dtos.GenericProductDto;
import dev.rahul.productservice.exceptions.NotFoundException;
import dev.rahul.productservice.models.Category;
import dev.rahul.productservice.models.Product;
import dev.rahul.productservice.repositories.CategoryRepository;
import dev.rahul.productservice.repositories.ProductRepository;
import dev.rahul.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductServiceClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("SelfProductServiceImpl")
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;


    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository  = categoryRepository;
    }

    private GenericProductDto convertProductIntoGenericProductDto(Product product){
        GenericProductDto productDto = new GenericProductDto();
        productDto.setId(product.getId().toString());
        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setTitle(product.getTitle());
        productDto.setImage(product.getImage());
        productDto.setCategory(product.getCategory().getName());
        return productDto;
    }

    private Product convertGenericDtoToProduct(GenericProductDto genericProductDto){
        Product product = new Product();
        if(genericProductDto.getId()!=null)
            product.setId(UUID.fromString(genericProductDto.getId()));
        product.setTitle(genericProductDto.getTitle());
        product.setDescription(genericProductDto.getDescription());
        product.setTitle(genericProductDto.getTitle());
        product.setImage(genericProductDto.getImage());
        Category category =  categoryRepository.findByNameEquals(genericProductDto.getCategory()).get();
        if(category == null){
            category = new Category();
            category.setName(genericProductDto.getCategory());
        }
        product.setCategory(category);
        return product;
    }

    @Override
    public List<GenericProductDto> getAllProducts(){
        List<Product> products = productRepository.findAll();
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for(Product product : products){
            genericProductDtos.add(convertProductIntoGenericProductDto(product));
        }
        return genericProductDtos;
    }

    @Override
    public GenericProductDto getProductById(String id) throws NotFoundException {
        Product product = productRepository.findById(UUID.fromString(id)).get();
        if(product == null){
            throw new NotFoundException("Product with id " +  id + " doesn't exist.");
        }
        return convertProductIntoGenericProductDto(product);

    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto){
        Product product = convertGenericDtoToProduct(genericProductDto);
        Product savedProduct = productRepository.save(product);

//        FakeStoreProductDto fakeStoreProductDto =  fakeStoreProductServiceClient.createProduct(product);
//        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto);
        return convertProductIntoGenericProductDto(savedProduct);
    }

    @Override
    public GenericProductDto updateProductById(String id, GenericProductDto genericProductDto) throws NotFoundException{
        UUID productId = UUID.fromString(id);
        Product savedProduct = productRepository.findById(productId).get();
        if (savedProduct==null){
            throw new NotFoundException("Product with id " +  id + " doesn't exist.");
        }
        Product product = convertGenericDtoToProduct(genericProductDto);
        product.setId(productId);
//        savedProduct = productRepository.update

//        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductServiceClient.updateProductById(id, product);
//        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto);
        return null;
    }

    @Override
    public GenericProductDto deleteProductById(String id) throws NotFoundException{
        UUID productId = UUID.fromString(id);
        Product product = productRepository.findById(productId).get();
        if(product == null){
            throw new NotFoundException("Product with id " +  id + " doesn't exist.");
        }
        productRepository.deleteById(UUID.fromString(id));
//        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductServiceClient.deleteProductById(id);
//        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto);
        return convertProductIntoGenericProductDto(product);
    }

}
