package com.tuon.tsells.repositories;

import com.tuon.tsells.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
