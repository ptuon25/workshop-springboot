package com.tuon.tsells.repositories;

import com.tuon.tsells.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
