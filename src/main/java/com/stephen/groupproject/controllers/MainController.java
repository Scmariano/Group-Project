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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stephen.groupproject.models.Product;

import com.stephen.groupproject.services.ProductServ;
import com.stephen.groupproject.services.UserServ;

@Controller
public class MainController {
	@Autowired
	UserServ userServ;
	@Autowired
	ProductServ productServ;

	@GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/logout";
        } else {
            model.addAttribute("user", userServ.findById(userId));
            model.addAttribute("products", productServ.allProducts());
            model.addAttribute("cart", userServ.findById(userId).getCart());
            return "index.jsp";
        }
    }
    

	// Render an Edit Product
	@GetMapping("/update/{id}")
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
	@PutMapping("/edit/{id}")
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
	@RequestMapping("/delete/{id}")
	public String destroyProduct(@PathVariable("id")Long id, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");

	    if(userId == null) {
            return "redirect:/logout";
        }else {
        	productServ.deleteProduct(id);
        	return "redirect:/dashboard";
        }
	}
	
	
	
	
	

}
