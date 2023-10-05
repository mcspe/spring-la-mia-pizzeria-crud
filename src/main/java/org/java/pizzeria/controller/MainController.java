package org.java.pizzeria.controller;

import java.util.List;

import org.java.pizzeria.db.pojo.Pizza;
import org.java.pizzeria.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping
	public String getIndex(Model model) {
		
		List<Pizza> pizzas = pizzaService.findAll();
		model.addAttribute("pizzas", pizzas);
		
		return "index";
		
	}
	
	@GetMapping("/details/{id}")
	public String getShow(@PathVariable int id, Model model) {
		
		String pageTitle = "Pizza Detail";
		Pizza pizza = pizzaService.findById(id);
		
		float priceVal = pizza.getPrice() / 100f;
		String priceFormat = String.format("€%,.2f", priceVal);
		
		model.addAttribute("pageTitle", pageTitle);
		model.addAttribute("pizza", pizza);
		model.addAttribute("priceFormat", priceFormat);
		
		return "detail";
	}

}
