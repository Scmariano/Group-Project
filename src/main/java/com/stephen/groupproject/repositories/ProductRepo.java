package com.stephen.groupproject.repositories;

import java.util.List;
<<<<<<< HEAD

=======
>>>>>>> 65c39e13908fd5f77f6fae5dfb2549437697aa0b

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stephen.groupproject.models.Product;


@Repository
public interface ProductRepo extends CrudRepository <Product, Long> {
	public List<Product>findAll();
<<<<<<< HEAD
	

=======
>>>>>>> 65c39e13908fd5f77f6fae5dfb2549437697aa0b
}
