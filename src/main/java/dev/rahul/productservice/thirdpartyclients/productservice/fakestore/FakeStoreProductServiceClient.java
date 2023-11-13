package dev.rahul.productservice.thirdpartyclients.productservice.fakestore;

import dev.rahul.productservice.dtos.FakeStoreProductDto;
import dev.rahul.productservice.dtos.GenericProductDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;


@Service
public class FakeStoreProductServiceClient{

    @Value("${fakestore.api.url}")
    private String fakestoreApiurl;

    @Value("${fakestore.api.paths.product}")
    private String fakeStoreProductsApiPath;

    private String SPECIFIC_PRODUCT_URL;
    private String PRODUCTS_URL;

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder, @Value("${fakestore.api.url}") String fakestoreApiurl, @Value("${fakestore.api.paths.product}") String fakeStoreProductsApiPath) {
        this.restTemplateBuilder = restTemplateBuilder;

        SPECIFIC_PRODUCT_URL = fakestoreApiurl + fakeStoreProductsApiPath + "/{id}";
        PRODUCTS_URL =  fakestoreApiurl + fakeStoreProductsApiPath;
    }

    public FakeStoreProductDto[] getAllProducts(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(PRODUCTS_URL, FakeStoreProductDto[].class);
        return response.getBody();
    }

    public FakeStoreProductDto getProductById(Long id){
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(SPECIFIC_PRODUCT_URL, FakeStoreProductDto.class, id);
        return response.getBody();
    }

    public FakeStoreProductDto createProduct(GenericProductDto product){
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity(PRODUCTS_URL, product, FakeStoreProductDto.class);
        System.out.println(response.getStatusCode());
        return response.getBody();
    }

    public FakeStoreProductDto updateProductById(Long id, GenericProductDto product){
        RestTemplate restTemplate = restTemplateBuilder.build();
//        restTemplate.execute(SPECIFIC_PRODUCT_URL, HttpMethod.PUT, null, null, id)
//        restTemplate.put(SPECIFIC_PRODUCT_URL, product, GenericProductDto.class, id);
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(SPECIFIC_PRODUCT_URL, HttpMethod.PUT, requestCallback, responseExtractor, id);
        return response.getBody();
    }

    public FakeStoreProductDto deleteProductById(Long id){
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(SPECIFIC_PRODUCT_URL, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        return response.getBody();
    }
}
