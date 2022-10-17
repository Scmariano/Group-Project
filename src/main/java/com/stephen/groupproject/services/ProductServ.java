package com.stephen.groupproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stephen.groupproject.models.Cart;
import com.stephen.groupproject.models.Product;
import com.stephen.groupproject.models.User;
import com.stephen.groupproject.repositories.CartRepo;
import com.stephen.groupproject.repositories.ProductRepo;

@Service
public class ProductServ {
	@Autowired ProductRepo productRepo;
	@Autowired CartRepo cartRepo;
	
	
	// show all products
	public List<Product>allProducts(){
		return productRepo.findAll();
	}
	
	// create
	public Product createProduct(Product product) {
		return productRepo.save(product);
	}
	
	//Update	
	public Product updateProduct(Product product) {
		return productRepo.save(product);
	}
	
	//Delete Product
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
	}
	
	//Get a Product
	public Product findProductId(Long id) {
		Optional<Product>optPro = productRepo.findById(id);
		if(optPro.isPresent()) {
			return optPro.get();
		}else{
			return null;
		}
	}
	
	// Get the Liker
	public Product findLikerId(Long likerId) {
		Optional<Product>optLiker = productRepo.findLikersById(likerId);
		if(optLiker.isPresent()) {
			return optLiker.get();
		}else {
			return null;
		}
	}
	
	// liking a product
	public void likeProduct(Product product, User userId) {
		List<User>likers = product.getLikers();
		likers.add(userId);
		productRepo.save(product);
	}
	
	// unliking a product
	public void unLikeProduct(Product product, User userId) {
		List<User>likers = product.getLikers();
		likers.remove(userId);
		productRepo.save(product);
	}
	
	//Add Product to cart
	public void addToCart(Cart cart, Product product) {
		List<Product>productInCart = cart.getProductInCart();
		cart.increment();
		productInCart.add(product);
		productRepo.save(product);
	}
	
	
	//Remove Product to cart
	public void removeToCart(Cart cart, Product product) {
		List<Product>productInCart = cart.getProductInCart();
		cart.decriment();
		productInCart.remove(product);
		productRepo.save(product);
	}
	
}
