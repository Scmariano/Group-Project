package com.stephen.groupproject.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stephen.groupproject.models.Product;


@Repository
public interface ProductRepo extends CrudRepository <Product, Long> {
	public List<Product>findAll();
	public Optional<Product>findLikersById(Long likerId);

}
