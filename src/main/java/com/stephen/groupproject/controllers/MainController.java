package com.stephen.groupproject.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.stephen.groupproject.services.ProductServ;
import com.stephen.groupproject.services.UserServ;

@Controller
public class MainController {
	@Autowired UserServ userServ;
	@Autowired ProductServ productServ;
	
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/logout";
		}else {
			model.addAttribute("user", userServ.findById(userId));
			model.addAttribute("products", productServ.allProducts());
			return "index.jsp";
		}
	}
	
	
	
	
	
}
