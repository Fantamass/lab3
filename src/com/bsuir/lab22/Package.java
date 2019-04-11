package com.bsuir.lab22;

import java.util.List;

import com.bsuir.lab22.product.Product;

public class Package {
	List<Product> items;
	
	void place(List<Product> items) {
		this.items = items;
	}
}
