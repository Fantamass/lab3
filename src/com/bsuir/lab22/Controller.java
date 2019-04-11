package com.bsuir.lab22;


import java.util.List;

import com.bsuir.lab22.product.Product;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Controller {
    private static Controller instance;      
    public static Controller getInstance() {
        if(instance == null)
        	instance = new Controller();
        else if (view == null)
        	return null;        
        return instance;
    }
    
    private static View view;
    
    public void setStage(Stage viewStage) {
    	view = new View(viewStage);
    }
    
    public void start() {
    	view.create();
    	view.show();
    }

    public ObservableList<Product> getProductsCollection(){
    	return FXCollections.observableArrayList(Model.getInstance().getShopProducts());
    }

    
    public void buyButtonPressed() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(Strings.ALERT_TITLE);

    	if(Model.getInstance().cartGetStored().size() == 0)
			alert.setHeaderText(Strings.INFO_CARD_EMPTY);
    	else {
    		int price = Model.getInstance().shopAskForMoney();
    		if(price == 0)
    			alert.setHeaderText(Strings.INFO_NO_MONEY);
    		else {
    			alert.setHeaderText("Списано " + String.valueOf(price) + " рублей");
    			Model.getInstance().setPaid();
    		}
    	}        
        alert.showAndWait();
    }
    
    public void getButtonPressed() {
    	Product geted = view.getComboBoxes().get("Products").getValue();
    	if(geted != null)
    		Model.getInstance().customerHoldProduct(geted);
    }
    
    public void putButtonPressed() {
    	Model.getInstance().cartStoreProduct();
    	List<Product> cartStored = Model.getInstance().cartGetStored();   	
    	if (cartStored == null) return;
    	for(int i = 0; i < cartStored.size(); ++i)
    	{
    		view.getLabels().get("cart" + String.valueOf(i + 1)).setText(cartStored.get(i).toString());
    	}
		Model.getInstance().setNotPaid();
    }   
    
    public void toPackageButtonPressed() {
    	if (!Model.getInstance().paid()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle(Strings.ALERT_TITLE);
            alert.setHeaderText(Strings.NOT_PAID);
            alert.showAndWait();
    	}
    	
    	view.getLabels().get("package1").setText(view.getLabels().get("cart1").getText());
    	view.getLabels().get("package2").setText(view.getLabels().get("cart2").getText());
    	view.getLabels().get("package3").setText(view.getLabels().get("cart3").getText());
    	Model.getInstance().cartToPackage();
		Model.getInstance().setNotPaid();
    	clearButtonPressed();
    }  
    
    public void clearButtonPressed() {
    	Model.getInstance().cartClear();
    	view.getLabels().get("cart1").setText("");
    	view.getLabels().get("cart2").setText("");
    	view.getLabels().get("cart3").setText("");
    }
}
