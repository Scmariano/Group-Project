package com.stephen.groupproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;

import com.stephen.groupproject.models.ProductInCart;

@Repository
public interface ProductInCartRepo extends CrudRepository<ProductInCart, Long>{
    List<ProductInCart> findAll();
}
=======

import com.stephen.groupproject.models.ProductInCart;

public interface ProductInCartRepo extends CrudRepository<ProductInCart, Long>{
	List<ProductInCart> findAll();
}
>>>>>>> 65c39e13908fd5f77f6fae5dfb2549437697aa0b
