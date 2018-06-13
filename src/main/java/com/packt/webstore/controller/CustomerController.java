package com.packt.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.packt.webstore.domain.repository.CustomerRepository;
//import java.math.BigDecimal;
//import com.packt.webstore.domain.Product;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@RequestMapping("/customers")
	public String list(Model model) {
		model.addAttribute("customers", customerRepository.getAllCustomers());
		return "customers";
		
	}
}