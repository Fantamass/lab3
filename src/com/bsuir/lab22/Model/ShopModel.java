package com.bsuir.lab22.Model;

import java.util.List;
import java.util.Set;

import com.bsuir.lab22.product.*;

public class ShopModel {
    private static ShopModel instance;      
    public static ShopModel getInstance() {
        if(instance == null) {
        	instance = new ShopModel();       
        } 
        return instance;
    }
    
    private Shop shop = new Shop();
    private Customer customer  = new Customer(100);
    private Cart cart = new Cart();
    private Package pack = new Package();
    private boolean paid;
    
    public boolean paid() {
    	return paid;
    }  
    
    public void setPaid() {
    	paid = true;
    }
    
    public void setNotPaid() {
    	paid = false;
    }
    
    public Set<Product> getShopProducts() {
    	return shop.getProducts();
    }
    
    public void customerHoldProduct(Product product) {
    	customer.holdProduct(product);
    }   
    
    public Product customerGetHolded() {
    	return customer.getHolded();
    }  
    
    public void cartStoreProduct() {
    	customer.putIntoCart(cart);
    }
    
    public List<Product> cartGetStored() {
    	return cart.getStored();
    }  
    
    public int shopAskForMoney() {
    	return shop.askForMoney(customer, cart);
    }
    
    public void cartToPackage() {
    	customer.toPackage(cart, pack);
    }
    
    public void cartClear() {
    	cart.getStored().clear();
    }
}
