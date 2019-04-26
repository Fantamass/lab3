package com.bsuir.lab22.View;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.HashMap;
import java.util.Map;

import com.bsuir.lab22.product.*;
import com.bsuir.lab22.Controller.*;
import com.bsuir.lab22.Constant.*;

public class ShopView {
	private Stage primaryStage;
	private GridPane gridPane; 
	private Map<String, Label> labels  = new HashMap<String, Label>();
	private Map<String, ComboBox<Product>> comboBoxes  = new HashMap<String, ComboBox<Product>>();
	
	public Map<String, Label> getLabels(){
		return labels;
	}	
	
	public Map<String, ComboBox<Product>> getComboBoxes(){
		return comboBoxes;
	}
	
	public ShopView(Stage viewStage) {
			primaryStage = viewStage;
			gridPane = new GridPane();
	        gridPane.setPadding(new Insets(5));
	        gridPane.setVgap(10); 
	        gridPane.setHgap(10); 
	        
	        for(int i = 0; i < 3; ++i) {
		        ColumnConstraints col = new ColumnConstraints();
		        col.setPercentWidth(33);
		        gridPane.getColumnConstraints().add(col);
	        }
	        
	        viewStage.setTitle(Strings.SHOP_NAME);
	}
	
	private Button addButton(String title, int positionX, int positionY) {
		Button newButton = new Button(title);
        gridPane.add(newButton, positionY, positionX);
        newButton.setMaxWidth(Double.MAX_VALUE);
        newButton.setMaxHeight(Double.MAX_VALUE);
        GridPane.setHgrow(newButton, Priority.ALWAYS);
        GridPane.setVgrow(newButton, Priority.ALWAYS);
        newButton.setFont(new Font("Arial", 14));
        return newButton;
	}
	
	private void addLabel(String title, String id, int positionX, int positionY) {
		Label newLabel = new Label(title);
        gridPane.add(newLabel, positionY, positionX);
        newLabel.setMaxWidth(Double.MAX_VALUE);
        newLabel.setMaxHeight(Double.MAX_VALUE);
        GridPane.setHgrow(newLabel, Priority.ALWAYS);
        GridPane.setVgrow(newLabel, Priority.ALWAYS);
        newLabel.setFont(new Font("Arial", 20));
        labels. put(id, newLabel);
	}
	
	public void insertButtons() {
		addButton(Strings.BUTTON_BUY, 1, 1).setOnMouseClicked( (MouseEvent event) -> {ShopController.getInstance().buyButtonPressed();} );		
		addButton(Strings.BUTTON_GET, 0, 1).setOnMouseClicked((MouseEvent event) -> {ShopController.getInstance().getButtonPressed();} );	
		addButton(Strings.BUTTON_PUT, 0, 2).setOnMouseClicked((MouseEvent event) -> {ShopController.getInstance().putButtonPressed();} );	
		addButton(Strings.BUTTON_PACKAGE, 2, 1).setOnMouseClicked((MouseEvent event) -> {ShopController.getInstance().toPackageButtonPressed();} );	
		addButton(Strings.BUTTON_CLEAR, 3, 1).setOnMouseClicked((MouseEvent event) -> {ShopController.getInstance().clearButtonPressed();} );	
	}
	
	public void insertLabels() {
		addLabel(Strings.LABEL_SHOPPING_CARD, Strings.LABEL_SHOPPING_CARD, 1, 0);
		addLabel("", "cart1", 2, 0);
		addLabel("", "cart2", 3, 0);
		addLabel("", "cart3", 4, 0);
		addLabel(Strings.LABEL_PACKAGE, Strings.LABEL_PACKAGE, 1, 2);
		addLabel("", "package1", 2, 2);
		addLabel("", "package2", 3, 2);
		addLabel("", "package3", 4, 2);
	}
	
	public void insertComboBox() {
        ComboBox<Product> products = new ComboBox<Product>(ShopController.getInstance().getProductsCollection());
        gridPane.add(products, 0, 0);
        products.setMaxWidth(Double.MAX_VALUE);
        products.setMaxHeight(Double.MAX_VALUE);
        GridPane.setHgrow(products, Priority.ALWAYS);
        GridPane.setVgrow(products, Priority.ALWAYS);
        comboBoxes.put("Products", products);
	}
	
	public void insertElements() {
		insertButtons();
		insertLabels();
		insertComboBox();
	}

	public void create() {
		insertElements();
		Scene scene = new Scene(gridPane,300,200);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
	}
	
	public void show() {
		primaryStage.show();
	}
}
