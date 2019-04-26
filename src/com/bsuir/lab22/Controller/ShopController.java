package com.bsuir.lab22.Controller;


import java.util.List;

import com.bsuir.lab22.product.Product;
import com.bsuir.lab22.View.ShopView;
import com.bsuir.lab22.Constant.*;
import com.bsuir.lab22.Model.ShopModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ShopController {
    private static ShopController instance;      
    public static ShopController getInstance() {
        if(instance == null)
        	instance = new ShopController();
        else if (view == null)
        	return null;        
        return instance;
    }
    
    private static ShopView view;
    
    public void setStage(Stage viewStage) {
    	view = new ShopView(viewStage);
    }
    
    public void start() {
    	view.create();
    	view.show();
    }

    public ObservableList<Product> getProductsCollection(){
    	return FXCollections.observableArrayList(ShopModel.getInstance().getShopProducts());
    }

    
    public void buyButtonPressed() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(Strings.ALERT_TITLE);

    	if(ShopModel.getInstance().cartGetStored().size() == 0)
			alert.setHeaderText(Strings.INFO_CARD_EMPTY);
    	else {
    		int price = ShopModel.getInstance().shopAskForMoney();
    		if(price == 0)
    			alert.setHeaderText(Strings.INFO_NO_MONEY);
    		else {
    			alert.setHeaderText("Списано " + String.valueOf(price) + " рублей");
    			ShopModel.getInstance().setPaid();
    		}
    	}        
        alert.showAndWait();
    }
    
    public void getButtonPressed() {
    	Product geted = view.getComboBoxes().get("Products").getValue();
    	if(geted != null)
    		ShopModel.getInstance().customerHoldProduct(geted);
    }
    
    public void putButtonPressed() {
    	ShopModel.getInstance().cartStoreProduct();
    	List<Product> cartStored = ShopModel.getInstance().cartGetStored();   	
    	if (cartStored == null) return;
    	for(int i = 0; i < cartStored.size(); ++i)
    	{
    		view.getLabels().get("cart" + String.valueOf(i + 1)).setText(cartStored.get(i).toString());
    	}
    	ShopModel.getInstance().setNotPaid();
    }   
    
    public void toPackageButtonPressed() {
    	if (!ShopModel.getInstance().paid()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle(Strings.ALERT_TITLE);
            alert.setHeaderText(Strings.NOT_PAID);
            alert.showAndWait();
    	}
    	
    	for(int i = 1; i < 4; ++i){
            String cartItem = view.getLabels().get("cart" + i).getText();
            view.getLabels().get("package" + i).setText(cartItem);
    	}
    	
    	ShopModel.getInstance().cartToPackage();
    	ShopModel.getInstance().setNotPaid();
    	clearButtonPressed();
    }  
    
    public void clearButtonPressed() {
    	ShopModel.getInstance().cartClear();
    	view.getLabels().get("cart1").setText("");
    	view.getLabels().get("cart2").setText("");
    	view.getLabels().get("cart3").setText("");
    }
}
