package com.stephen.groupproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stephen.groupproject.models.Product;
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
    
}