package com.bsuir.lab22.Model;

import java.util.List;

import com.bsuir.lab22.product.Product;

public class Package {
	private List<Product> items;
	
	public void place(List<Product> items) {
		this.items = items;
	}
}
