package dev.rahul.productservice;

//import dev.rahul.productservice.inheritancedemo.joinedtable.Mentor;
//import dev.rahul.productservice.inheritancedemo.joinedtable.MentorRepository;
//import dev.rahul.productservice.inheritancedemo.joinedtable.User;
//import dev.rahul.productservice.inheritancedemo.joinedtable.UserRepository;
import dev.rahul.productservice.models.Category;
import dev.rahul.productservice.models.Price;
import dev.rahul.productservice.models.Product;
import dev.rahul.productservice.repositories.PriceRepository;
import org.springframework.boot.CommandLineRunner;
import dev.rahul.productservice.repositories.CategoryRepository;
import dev.rahul.productservice.repositories.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class ProductserviceApplication
//        implements CommandLineRunner
{
//    private final ProductRepository productRepository;
//    private final CategoryRepository categoryRepository;
//    private final PriceRepository priceRepository;
//
//    public ProductserviceApplication(ProductRepository productRepository,
//                                     CategoryRepository categoryRepository,
//                                     PriceRepository priceRepository){
//        this.productRepository = productRepository;
//        this.categoryRepository = categoryRepository;
//        this.priceRepository = priceRepository;
//    }
    public static void main(String[] args) {
        SpringApplication.run(ProductserviceApplication.class, args);
    }
//    @Override
//    public void run(String... args) throws Exception{
////        Category category = new Category();
////        category.setName("Apple Device");
////
////        Price price = new Price("Rupee", 10);
////
////        Product product = new Product();
////        product.setTitle("Iphone 15 Pro");
////        product.setDescription("Best Iphone ever.");
////        product.setCategory(category);
////        product.setPrice(price);
////        productRepository.save(product);
////
////        List<Product> products = productRepository.findAllByTitle("Iphone 15 Pro");
////        for(Product prod : products){
////            System.out.println(prod.getTitle());
////        }
//
////        Category category1 = categoryRepository.findById(UUID.fromString("d39c7daa-7596-4d0e-8393-68241c212a44")).get();
////        System.out.println("Category name is : "+category1.getName());
////        System.out.println("Printing all categories in the category");
////        for(Product product1: category1.getProducts()) {
////            try{
////                System.out.println(product1.getTitle());
////            }catch(Exception e){
////                System.out.println(e.getMessage());
////            }
////        }
////        doSomething();
//    }
//
//    public void doSomething() throws Exception{
//        System.out.println("Fetching category 9ceb0ed9-a62b-492d-91ab-a283c80e4819");
//        Thread.sleep(1000);
//        Optional<Category> categoryOption = categoryRepository.findById(UUID.fromString("9ceb0ed9-a62b-492d-91ab-a283c80e4819"));
//        Category category1 = categoryOption.get();
//
//        System.out.println("Fetching products for category");
//        Thread.sleep(1000);
//        List<Product> products = category1.getProducts();
//
//    }
}
