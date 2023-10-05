package org.java.pizzeria;

import org.java.pizzeria.db.pojo.Pizza;
import org.java.pizzeria.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {
	
	@Autowired
	private PizzaService pizzaService;

	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Pizza p1 = new Pizza("Margherita", "Lorem ipsum dolor sit amet consectetur adipisicing elit.", "https://images.prismic.io/eataly-us/ed3fcec7-7994-426d-a5e4-a24be5a95afd_pizza-recipe-main.jpg?auto=compress,format", 650);
		Pizza p2 = new Pizza("Diavola", "Lorem ipsum dolor sit amet consectetur adipisicing elit.", "https://www.silviocicchi.com/pizzachef/wp-content/uploads/2015/03/d2.jpg", 850);
		Pizza p3 = new Pizza("Marinara", "Lorem ipsum dolor sit amet consectetur adipisicing elit.", "https://www.melarossa.it/wp-content/uploads/2022/05/pizza-marinara.jpg", 650);
		Pizza p4 = new Pizza("Vegetariana", "Lorem ipsum dolor sit amet consectetur adipisicing elit.", "https://patrioli.it/wp-content/uploads/2022/01/immagine-1.png", 750);
		Pizza p5 = new Pizza("Capricciosa", "Lorem ipsum dolor sit amet consectetur adipisicing elit.", "https://primochef.it/wp-content/uploads/2018/05/SH_pizza_capricciosa.jpg", 850);
		Pizza p6 = new Pizza("Gourmet", "Lorem ipsum dolor sit amet consectetur adipisicing elit.", "https://www.giginoefigli.it/wp-content/uploads/2019/10/Golosa-pizza-con-ragu%CC%80-e-polpettine-del-mese-di-Ottobre.jpg", 1200);
		
		pizzaService.save(p1);
		pizzaService.save(p2);
		pizzaService.save(p3);
		pizzaService.save(p4);
		pizzaService.save(p5);
		pizzaService.save(p6);
		
		System.out.println("Insert OK!");
	}

}
