package dev.rahul.productservice.repositories;

import dev.rahul.productservice.models.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;


@Repository
public interface ProductRepository
extends JpaRepository<Product, UUID> {
//    @Override
//    <S extends PRoduct, R> R findBy

    Product findByTitleEquals(String title);

//    Product findByTitleEqualsAndPrice_Price(String title, double price);

//    List<Product> findAllByPrice_Currency(String currency);

    List<Product> readAllByTitleLike(String titleRegex);

////    @Query(value = "select * from product join product_orders on product_id = product_orders.product_id where title=:title_name", nativeQuery = true)
//    @Query("select Product from Product where Product.title=:title_name and Product.price.currency=currency")
//    List<Product> findAllByTitle(String title_name, String currency);

//    @Query("update Product set u.firstname = ?1 where u.lastname = ?2")
//    Product updateById(UUID id, Product product);
}
