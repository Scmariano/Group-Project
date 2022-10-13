package com.stephen.groupproject.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="cart")
public class Cart {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Range(min=1, message = "Minimum item that you can have is 1")
	private int count;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User userInCart;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product productInCart;

	public Cart() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public User getUserInCart() {
		return userInCart;
	}

	public void setUserInCart(User userInCart) {
		this.userInCart = userInCart;
	}

	public Product getProductInCart() {
		return productInCart;
	}

	public void setProductInCart(Product productInCart) {
		this.productInCart = productInCart;
	}
	
	
	
}
