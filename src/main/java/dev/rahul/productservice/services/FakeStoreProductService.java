package dev.rahul.productservice.services;


import dev.rahul.productservice.dtos.FakeStoreProductDto;
import dev.rahul.productservice.dtos.GenericProductDto;
import dev.rahul.productservice.exceptions.NotFoundException;
import dev.rahul.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductServiceClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreProductServiceImpl")
public class FakeStoreProductService implements ProductService {

    private FakeStoreProductServiceClient fakeStoreProductServiceClient;

    private GenericProductDto convertFakeStoreProductIntoGenericProduct(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto product = new GenericProductDto();
        product.setId(String.valueOf(fakeStoreProductDto.getId()));
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setImage(fakeStoreProductDto.getImage());
        product.setCategory(fakeStoreProductDto.getCategory());
        return product;
    }

    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient) {
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }

    @Override
    public List<GenericProductDto> getAllProducts(){
        FakeStoreProductDto[] fakeStoreProductDtos =  fakeStoreProductServiceClient.getAllProducts();
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto: fakeStoreProductDtos){
            GenericProductDto product = convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto);
            genericProductDtos.add(product);
        }
        return genericProductDtos;
    }

    @Override
    public GenericProductDto getProductById(String id) throws NotFoundException {
        Long fakeStoreId = Long.valueOf(id);
        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductServiceClient.getProductById(fakeStoreId);
        if(fakeStoreProductDto == null){
            throw new NotFoundException("Product with id " +  id + " doesn't exist.");
        }
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto);

    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product){
        FakeStoreProductDto fakeStoreProductDto =  fakeStoreProductServiceClient.createProduct(product);
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto);
    }

    @Override
    public GenericProductDto updateProductById(String id, GenericProductDto product){
        Long fakeStoreId = Long.valueOf(id);
        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductServiceClient.updateProductById(fakeStoreId, product);
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto);
    }

    @Override
    public GenericProductDto deleteProductById(String id){
        Long fakeStoreId = Long.valueOf(id);
        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductServiceClient.deleteProductById(fakeStoreId);
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto);
    }

}
