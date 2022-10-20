package com.stephen.groupproject.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stephen.groupproject.models.Cart;

@Repository
public interface CartRepo extends CrudRepository<Cart, Long> {
    Optional<Cart> findById(Long id);
}
