package dev.rahul.productservice.repositories;

import dev.rahul.productservice.models.Category;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@Repository
public interface CategoryRepository
extends JpaRepository <Category, UUID>{

    Optional<Category> findById(UUID uuid);

    Optional<Category> findByNameEquals(String name);
}
