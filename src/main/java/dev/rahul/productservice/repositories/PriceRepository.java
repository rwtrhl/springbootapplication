package dev.rahul.productservice.repositories;

import dev.rahul.productservice.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PriceRepository
extends JpaRepository<Price, UUID> {
}
