package org.java.pizzeria.controller;

import java.util.List;

import org.java.pizzeria.db.pojo.Pizza;
import org.java.pizzeria.db.pojo.PizzaDTO;
import org.java.pizzeria.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping
	public String getIndex(@RequestParam(required = false) String pizza, Model model) {
		
		List<Pizza> pizzas = (pizza == null || pizza.isBlank())	? pizzaService.findAll() 
												: pizzaService.search(pizza);
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

	@GetMapping("/create")
	public String getCreate(Model model) {
		
		String pageTitle = "Add a new Pizza";
		
		model.addAttribute("pageTitle", pageTitle);
		model.addAttribute("pizzaDTO", new PizzaDTO());
		
		return "create";
	}
	
	@PostMapping("/create")
	public String store(
			@Valid @ModelAttribute PizzaDTO pizzaDTO, 
			BindingResult bindingResult, 
			Model model
			) {
		
		if(bindingResult.hasErrors()) {
			System.out.println("Error:");
			bindingResult.getAllErrors().forEach(System.out::println);
					
			return "create";
		}
		
		Pizza pizza = new Pizza(pizzaDTO.getName(),	pizzaDTO.getDescription(), pizzaDTO.getImg(), pizzaDTO.getIntPrice());
	
		pizzaService.save(pizza);
		
		return "redirect:/details/" + pizza.getId();
	}
	
}
