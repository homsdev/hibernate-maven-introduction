package com.homsdev.DemoHibernate;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Laptop {
	@Id
	private int id;
	private String model;
	private int price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", model=" + model + ", price=" + price + "]";
	}

}
