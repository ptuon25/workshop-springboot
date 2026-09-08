package com.tuon.tsells.resources;

import com.tuon.tsells.entities.User;
import com.tuon.tsells.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private final UserRepository repository;

    public UserResource(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = repository.findAll();
        return ResponseEntity.ok().body(list);
    }
}
