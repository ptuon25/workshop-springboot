package com.tuon.tsells.repositories;

import com.tuon.tsells.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
