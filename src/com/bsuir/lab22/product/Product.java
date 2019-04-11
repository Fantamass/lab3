package com.bsuir.lab22.product;

public abstract class Product {
	private int count;
	private String displayableName;
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count){
		this.count = count;
	}
	
	public Product(String name) {
		displayableName = name;
	}
	
	public String toString() {
		return displayableName;
	}
}
