package com.tuon.tsells.repositories;

import com.tuon.tsells.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
