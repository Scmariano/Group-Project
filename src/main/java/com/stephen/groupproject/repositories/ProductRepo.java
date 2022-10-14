package com.stephen.groupproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stephen.groupproject.models.Product;

@Repository
public interface ProductRepo extends CrudRepository <Product, Long> {

}
