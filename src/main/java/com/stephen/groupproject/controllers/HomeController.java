package com.stephen.groupproject.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.stephen.groupproject.models.Cart;
import com.stephen.groupproject.models.LoginUser;
import com.stephen.groupproject.models.ProductInCart;
import com.stephen.groupproject.models.User;
import com.stephen.groupproject.services.CartServ;
import com.stephen.groupproject.services.ProductInCartService;
import com.stephen.groupproject.services.ProductServ;
import com.stephen.groupproject.services.UserServ;

@Controller
public class HomeController {
    @Autowired UserServ userServ;
    @Autowired ProductServ productServ;
    @Autowired CartServ cartServ;
    @Autowired ProductInCartService productInCartServ;

	
	// Page for login/registration
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "login.jsp";
	}
	
	//Registration form
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		
		User user = userServ.register(newUser, result);
		
		if (result.hasErrors() || user == null) {
			model.addAttribute("newLogin", new LoginUser());
			return "login.jsp";
		} else {
			session.setAttribute("userId", user.getId());
			Cart newCart = new Cart();
			newCart.setUser(user);
			cartServ.createCart(newCart);

			return "redirect:/dashboard";
		}
		
	}
	
	//Login form
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin")LoginUser newLogin,
			BindingResult result, Model model, HttpSession session) {
		
		User user = userServ.login(newLogin, result);
		
		if(result.hasErrors() || user == null) {
			model.addAttribute("newUser", new User());
			return "login.jsp";
		}
			session.setAttribute("userId", user.getId());
			return "redirect:/dashboard";
		
	}
	
	@GetMapping("/add/product/{id}")
    public String  addProduct(@PathVariable("id") Long id, HttpSession session) {
        productInCartServ.AddToCart(productServ.findProductId(id), userServ.findById((Long) session.getAttribute("userId")).getCart().getId());     
        return "redirect:/dashboard";
    }
    
    @GetMapping("/cart")
    public String cart(Model model, HttpSession session) {
        model.addAttribute("user", userServ.findById((Long) session.getAttribute("userId")));
        model.addAttribute("products", userServ.findById((Long) session.getAttribute("userId")).getCart().getProductInCart());
        return "cart.jsp";
    }
	
=======
	public String  addProduct(@PathVariable("id") Long id, HttpSession session) {
		productInCartServ.AddToCart(productServ.findProductId(id), userServ.findById((Long) session.getAttribute("userId")).getCart().getId());		
		return "redirect:/dashboard";
	}
	
	@GetMapping("/cart")
	public String cart(Model model, HttpSession session) {
		int sportCount = 0;
		int tieCount = 0;
		int pantsCount = 0;
		int shirtCount = 0;
		for (ProductInCart product : userServ.findById((Long) session.getAttribute("userId")).getCart().getProductInCart()) {
			if (product.getProductName().equals("Sport Shoes")) {
				sportCount ++;
			}
			if (product.getProductName().equals("Tie")) {
				tieCount++;
			}
			if (product.getProductName().equals("Khaki Pants")) {
				pantsCount++;
			}
			if (product.getProductName().equals("White Shirt")) {
				shirtCount++;
			}
			model.addAttribute("sportCount", sportCount);
			model.addAttribute("tieCount", tieCount);
			model.addAttribute("shirtCount", shirtCount);
			model.addAttribute("pantsCount", pantsCount);
			model.addAttribute("user", userServ.findById((Long) session.getAttribute("userId")));
			model.addAttribute("products", userServ.findById((Long) session.getAttribute("userId")).getCart().getProductInCart());
		}
		
		return "cart.jsp";
	}

	
	@GetMapping("/edit/{id}")
	public String editProduct() {
		return "edit.jpg";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") Long id) {
		productInCartServ.deleteProductInCart(id);
		return "redirect:/cart";
	}
	
	
	//Get Method for logout/ We can change it to a Post if you guys want it to be a button form
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userId");
		return "redirect:/";
	}
}
