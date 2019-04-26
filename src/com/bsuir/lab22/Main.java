package com.bsuir.lab22;
	
import javafx.application.Application;
import javafx.stage.Stage;

import com.bsuir.lab22.Controller.ShopController;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		ShopController.getInstance().setStage(primaryStage);
		ShopController.getInstance().start();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
