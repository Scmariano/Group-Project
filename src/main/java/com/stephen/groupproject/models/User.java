package com.stephen.groupproject.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.OneToMany;
=======
>>>>>>> 65c39e13908fd5f77f6fae5dfb2549437697aa0b
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
<<<<<<< HEAD
=======
	
	@NotEmpty(message="Full name is required!")
    private String name;
>>>>>>> 65c39e13908fd5f77f6fae5dfb2549437697aa0b
    
    
    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @NotEmpty(message="Password is required!")
    @Size(min=8, max=255, message="Password must be between 8 and 128 characters")
    private String password;
    
    @Transient
    @NotEmpty(message="Confirm Password is required!")
    private String confirm;
    
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;
	
<<<<<<< HEAD
	
	
	
=======
>>>>>>> 65c39e13908fd5f77f6fae5dfb2549437697aa0b
	@OneToOne(mappedBy="user", fetch = FetchType.LAZY)
    private Cart cart;
	
	
	public User() {}
	
<<<<<<< HEAD
	public User(String email, String password, String confirm) {
		this.email = email;
		this.password = password;
		this.confirm = confirm;
=======
	public User(String name, String email, String password, String confirm) {
		this.email = email;
		this.password = password;
		this.confirm = confirm;
		this.cart = new Cart();
>>>>>>> 65c39e13908fd5f77f6fae5dfb2549437697aa0b
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

<<<<<<< HEAD



=======
>>>>>>> 65c39e13908fd5f77f6fae5dfb2549437697aa0b
	public Cart getCart() {
		return this.cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
<<<<<<< HEAD
=======
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

>>>>>>> 65c39e13908fd5f77f6fae5dfb2549437697aa0b
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	
	
	
	
	
}
