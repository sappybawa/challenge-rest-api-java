package com.sappy.challengerest.jpa;

import com.sappy.challengerest.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends MongoRepository<User, Long> {

    Optional<User> findById(String id);
    List<User> findByRole(String role);

}
