package com.packt.webstore.controller;

import com.packt.webstore.domain.dao.NewProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@Autowired
	private NewProductDao newProductDao;

	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("greeting", "Witaj na stronie Bistro");
		model.addAttribute("tagline", "Zapraszamy do składania zamówień");
		
		return "welcome";
	}

	@RequestMapping("/welcome/greeting")
	public String greeting() {
		return "welcome";
	}

	@RequestMapping("/employees")
	public String employeess() {
		return "employees";
	}

	@RequestMapping("/contact")
	public String contact() {
		return "contact";
	}

	//all products list from database with promo
	@RequestMapping("/productsPromo")
	public String showPromo(Model model) {
		model.addAttribute("products", newProductDao.findAll());
		return "productsPromo";
	}

}