package com.stephen.groupproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stephen.groupproject.models.ProductInCart;

@Repository
public interface ProductInCartRepo extends CrudRepository<ProductInCart, Long>{
    List<ProductInCart> findAll();
}