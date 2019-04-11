package com.bsuir.lab22;

import java.util.ArrayList;
import java.util.List;
import com.bsuir.lab22.product.*;

public class Cart {
	private List<Product> storedProduct = new ArrayList<Product>();
	
	public void storeProduct(Product product) {
		if(storedProduct.size() < 3)
			storedProduct.add(product);
	}
	
	public List<Product> getStored() {
		return storedProduct;
	}
	
	public void outStored() {
		storedProduct.clear();
	}
}
