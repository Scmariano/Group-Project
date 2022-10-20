package com.stephen.groupproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stephen.groupproject.models.Cart;
import com.stephen.groupproject.models.ProductInCart;
import com.stephen.groupproject.repositories.CartRepo;
import com.stephen.groupproject.repositories.ProductRepo;

@Service
public class CartServ {
	@Autowired ProductRepo productRepo;
	@Autowired CartRepo cartRepo;
	
	public Cart findCartById(Long id) {
		Optional<Cart> cart = cartRepo.findById(id);
		if (cart.isPresent()) {
			return cart.get();
		} else {
			return null;
		}
	}
	
	
	// create
	public Cart createCart(Cart cart) {
		return cartRepo.save(cart);
	}
	
	//Delete Product
	public void deleteCart(Long id) {
		cartRepo.deleteById(id);
	}
	
}

