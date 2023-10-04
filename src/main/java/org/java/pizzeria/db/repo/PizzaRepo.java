package org.java.pizzeria.db.repo;

import org.java.pizzeria.db.pojo.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepo extends JpaRepository<Pizza, Integer> {

}
