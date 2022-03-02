package com.assign;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Product implements Serializable {
	@Id
	int id;
	int quantity;
	String name;
	float price;
	@Override
	public String toString() {
		return "Product [id=" + id + ", quantity=" + quantity + ", name=" + name + ", price=" + price + ", discount="
				+ discount + "]";
	}

	float discount;

	public Product() {
	}

	public Product(int id, String name, float price, int quantity, float discount) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.discount = discount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

}
