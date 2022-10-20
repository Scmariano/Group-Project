package com.stephen.groupproject.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stephen.groupproject.models.Cart;

@Repository
public interface CartRepo extends CrudRepository<Cart, Long> {
<<<<<<< HEAD
    Optional<Cart> findById(Long id);
=======
	Optional<Cart> findById(Long id);
>>>>>>> 65c39e13908fd5f77f6fae5dfb2549437697aa0b
}
