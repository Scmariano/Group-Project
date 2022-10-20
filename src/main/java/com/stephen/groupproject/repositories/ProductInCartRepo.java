package com.stephen.groupproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.stephen.groupproject.models.ProductInCart;

public interface ProductInCartRepo extends CrudRepository<ProductInCart, Long>{
	List<ProductInCart> findAll();
}
