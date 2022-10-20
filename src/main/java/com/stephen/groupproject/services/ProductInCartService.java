package com.stephen.groupproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stephen.groupproject.models.Product;
import com.stephen.groupproject.models.ProductInCart;
import com.stephen.groupproject.repositories.CartRepo;
import com.stephen.groupproject.repositories.ProductInCartRepo;

@Service
public class ProductInCartService {
    @Autowired ProductInCartRepo productInCartRepo;
    @Autowired CartRepo cartRepo;
    @Autowired CartServ cartService;
    
    
    // show all products
    public List<ProductInCart> allProductsInCart() {
        return productInCartRepo.findAll();
    }
    
    // create
    public ProductInCart AddToCart(Product product, Long id) {
        ProductInCart productInCart = new ProductInCart(product.getImage(), product.getProductName(), product.getDescription(), product.getPrice());
        productInCart.setCart(cartService.findCartById(id));
        return productInCartRepo.save(productInCart);
    }
    
    //Update    
    public ProductInCart updateCartProduct(ProductInCart productInCart) {
        return productInCartRepo.save(productInCart);
    }
    
    //Delete Product
    public void deleteProductInCart(Long id) {
        productInCartRepo.deleteById(id);
    }
    
    //Get a Product
    public ProductInCart findProductInCartById(Long id) {
        Optional<ProductInCart>optPro = productInCartRepo.findById(id);
        if(optPro.isPresent()) {
            return optPro.get();
        }else{
            return null;
        }
    }
    
}