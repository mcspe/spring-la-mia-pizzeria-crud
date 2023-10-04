package org.java.pizzeria.db.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 40, nullable = false)
	private String name;
	
	@Column(length = 1000)
	private String description;
	
	@Column(length = 1000)
	private String foto;
	
	private int price;
	
	public Pizza() {}
	
	public Pizza(String name, String description, String foto, int price) {
		setName(name);
		setDescription(description);
		setFoto(foto);
		setPrice(price);
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "[" + getId() + "] " + getName() + "\n" + 
				"Description: " + getDescription() + "\n" + 
				"Price: " + getPrice();
	}
	
}