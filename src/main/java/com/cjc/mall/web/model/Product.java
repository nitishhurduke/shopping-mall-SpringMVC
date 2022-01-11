package com.cjc.mall.web.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String name;
	private int quantity;
	private double discount;
	private double price;
	private double newPrice;
	

	@OneToMany(cascade = CascadeType.ALL)
	private Set<Payment> payments = new HashSet<Payment>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<User> users = new HashSet<User>();
	
	
	public double getNewPrice() {
		return newPrice;
	}
	
	public void setNewPrice( ) {
		this.newPrice = this.price -( this.price*this.discount / 100);
	}
	
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}


	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getDiscount() {
		return this.discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
		setNewPrice();
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
		setNewPrice();
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", quantity=" + quantity + ", discount="
				+ discount + ", price=" + price + ", newPrice=" + newPrice + ", payments=" + payments + ", users="
				+ users + "]";
	}
}
