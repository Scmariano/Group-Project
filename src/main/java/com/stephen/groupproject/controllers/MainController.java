package com.stephen.groupproject.controllers;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stephen.groupproject.models.Product;
import com.stephen.groupproject.models.User;
import com.stephen.groupproject.services.ProductServ;
import com.stephen.groupproject.services.UserServ;

@Controller
public class MainController {
	@Autowired
	UserServ userServ;
	@Autowired
	ProductServ productServ;

	// Landing Page
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/logout";
		} else {
			model.addAttribute("user", userServ.findById(userId));
			model.addAttribute("products", productServ.allProducts());
			return "index.jsp";
		}
	}

	// Rendering a page to add a Product
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("products") Product product, HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/logout";
		} else {
			model.addAttribute("user", userServ.findById(userId));
			// Add a landing Page
			return "";
		}
	}

	// Create a product
	@PostMapping("/products/create")
	public String createProduct(@Valid @ModelAttribute("products") Product product, BindingResult result,
			HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/logout";
		}
		
		if (result.hasErrors()) {
			// Add a landing Page
			return "";
		} else {
			productServ.createProduct(product);
			return "redirect:/dashboard";
		}
	}

	// Show a Product
	@GetMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/logout";
		} else {
			model.addAttribute("user", userServ.findById(userId));
			model.addAttribute("product", productServ.findProductId(id));
			// This for showing the "users" who liked the product
			model.addAttribute("likers", productServ.findLikerId(userId));
			// Add a landing Page
			return "";
		}
	}
	
	// Render an Edit Product
	@GetMapping("/products/{id}/edit")
	public String editProduct(@PathVariable("id")Long id, Model model, HttpSession session) {
		 Long userId = (Long) session.getAttribute("userId");
	        if(userId==null) {
	            return "redirect:/logout";
	        }else {
	        	model.addAttribute("user", userServ.findById(userId));
				model.addAttribute("product", productServ.findProductId(id));
				// Add a landing Page
				return "";
	        }
	}
	
	// Edit Form for a product
	@PutMapping("/products/{id}/update")
	public String updateProduct(@Valid @ModelAttribute("products") Product product, BindingResult result,
			HttpSession session, @PathVariable("id")Long id ) {
		Long userId = (Long) session.getAttribute("userId");
        if(userId == null) {
            return "redirect:/logout";
        }
        if (result.hasErrors()) {
			// Add a landing Page
			return "";
		} else {
			productServ.updateProduct(product);
			return "redirect:/products" + id;
		}
        
	}
	
	// Delete a product
	@RequestMapping("/products/{id}/delete")
	public String destroyProduct(@PathVariable("id")Long id, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");

	    if(userId == null) {
            return "redirect:/logout";
        }else {
        	productServ.deleteProduct(id);
        	return "redirect:/dashboard";
        }
	}
	
	
	// a Tag for liking a product
	@GetMapping("/products/{id}/like")
	public String likeProduct(@PathVariable("id")Long id, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		Product thisProduct = productServ.findProductId(id);
		User loggedUser = userServ.findById(userId);
		productServ.likeProduct(thisProduct, loggedUser);
		return "redirect:/dashboard";
	}
	
	// a Tag for unliking a product
	@GetMapping("/products/{id}/unLike")
	public String unLikeProduct(@PathVariable("id")Long id, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		Product thisProduct = productServ.findProductId(id);
		User loggedUser = userServ.findById(userId);
		productServ.unLikeProduct(thisProduct, loggedUser);
		return "redirect:/dashboard";
	}
	
	

}
