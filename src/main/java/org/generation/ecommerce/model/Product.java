package org.generation.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// POJO Plain Old Java Object
@Entity
@Table(name="productos")
public class Product {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String description;
	private String URL_image;
	private double price;
	
	public Product(String name, String description, String uRL_image, double price) {
		super();
		this.name = name;
		this.description = description;
		URL_image = uRL_image;
		this.price = price;
	}//constructor
	
	public Product() {}//constructor
	
	public Long getId() {
		return id;
	}//getId
	
	public String getName() {
		return name;
	}//getName

	public void setName(String name) {
		this.name = name;
	}//setName

	public String getDescription() {
		return description;
	}//getDescription

	public void setDescription(String description) {
		this.description = description;
	}//setDescription

	public String getURL_image() {
		return URL_image;
	}//getURL_image

	public void setURL_image(String uRL_image) {
		URL_image = uRL_image;
	}//setURL_image

	public double getPrice() {
		return price;
	}//getPrice

	public void setPrice(double price) {
		this.price = price;
	}//setPrice

	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description + ", URL_image=" + URL_image + ", price="
				+ price + ", id=" + id + "]";
	}//toString

	
}//class Product
