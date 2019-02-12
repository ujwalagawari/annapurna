package com.capgemini.CartService.entity;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cart {

	@Id
	private int cartId;
	private String restaurantName;
	private Set<FoodProducts> products;
	private double totalAmount;
	private Address address;

	public Cart() {
		
	}
	
	public Cart(int cartId, String restaurantName, Set<FoodProducts> products,
				Address address) {
		super();
		this.cartId = cartId;
		this.restaurantName = restaurantName;
		this.products = products;
		this.address = address;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Set<FoodProducts> getProducts() {
		return products;
	}

	public void setProducts(Set<FoodProducts> products) {
		this.products = products;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", restaurantName=" + restaurantName + ", products=" + products
				+ ", address=" + address + "]";
	}



}
