package com.stephen.groupproject.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.Table;

@Entity
@Table(name="carts")
public class Cart {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    private int count;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;
    
    @OneToMany(mappedBy="cart", fetch = FetchType.LAZY)
    private List<ProductInCart> productInCart;

    public Cart() {
    }
    
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ProductInCart> getProductInCart() {
        return productInCart;
    }

    public void setProductInCart(List<ProductInCart> productInCart) {
        this.productInCart = productInCart;
    }


    
    
    
}