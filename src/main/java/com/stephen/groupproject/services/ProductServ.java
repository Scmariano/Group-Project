package com.stephen.groupproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stephen.groupproject.repositories.ProductRepo;

@Service
public class ProductServ {
	@Autowired ProductRepo productRepo;
	
	
	
}
