package com.bsuir.lab22;

import com.bsuir.lab22.product.*;;

public class Customer {
	private Product holdedProduct;
	private int money;
	
	public Customer(int money) {
		this.money = money;
	}
	
	public void holdProduct(Product product) {
		holdedProduct = product;
	}
		
	public Product getHolded() {
		return holdedProduct;
	}
	
	public void putIntoCart(Cart cart) {
		if(holdedProduct != null)
			cart.storeProduct(holdedProduct);
		holdedProduct = null;
	}
	
	public int pay(int sum) {
		if(money >= sum) {
			money = money - sum;
			return sum;
		}
		return 0;
	}
	
	public void toPackage (Cart cart, Package pack) {
		pack.place(cart.getStored());
	}
}
