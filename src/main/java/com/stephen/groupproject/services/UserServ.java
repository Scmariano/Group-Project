package com.stephen.groupproject.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.stephen.groupproject.models.LoginUser;
import com.stephen.groupproject.models.User;
import com.stephen.groupproject.repositories.CartRepo;
import com.stephen.groupproject.repositories.UserRepo;



@Service
public class UserServ {
	
	@Autowired UserRepo userRepo;
	@Autowired CartRepo cartRepo;
	
	// Registration call
	public User register(User newUser, BindingResult result) {
		Optional<User> user = userRepo.findByEmail(newUser.getEmail());
		
		if(user.isPresent()) {
			result.rejectValue("email", "Matches", "An account with that email already exists!");
		}
		
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
		}
		
		if(result.hasErrors()) {
			return null;
		}
		
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		
		return userRepo.save(newUser);
		
	}
	
	
	// Login call
	public User login(LoginUser newLogin, BindingResult result) {
		Optional<User> registeredUser = userRepo.findByEmail(newLogin.getEmail());
		
		if(!registeredUser.isPresent()) {
			result.rejectValue("email", "Matches", "User not found");
			return null;
		}
		
		User user = registeredUser.get();
		
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Password!");
		}
		
		if(result.hasErrors()) {
			return null;
		}
		return user;
	
	}
	
	// find a User
	public User findById(Long id) {
		Optional<User>optUser = userRepo.findById(id);
		if(optUser.isPresent()) {
			return optUser.get();
		}else {
			return null;
		}
	}
	
	
	// find User email
	public User findByEmail(String email) {
		Optional<User> userEmail = userRepo.findByEmail(email);
		if(userEmail.isPresent()) {
			return userEmail.get();
		}else {
			return null;
		}
	}
	
	// Show all User()
	public List<User>allUsers() {
		return userRepo.findAll();
	}
	
	// Update a user profile()
	public User updateUser(User user) {
		return userRepo.save(user);
	}
}
