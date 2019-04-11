package com.bsuir.lab22;

import java.util.HashSet;
import java.util.Set;

import com.bsuir.lab22.product.*;

public class Shop {
	Set<Product> products = new HashSet<Product>();
	
	
	public Shop() {
		products.add(new Bread());
		products.add(new Matches());
		products.add(new Milk());
	}
	
	public void addProducts(Product product) {
		products.add(product);
	}
	
	public Set<Product> getProducts() {
		return products;
	}
	
	public int askForMoney(Customer customer, Cart cart) {
		return customer.pay(cart.getStored().size() * 10);
	}
}
