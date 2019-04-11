package com.bsuir.lab22;
	
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Controller.getInstance().setStage(primaryStage);
		Controller.getInstance().start();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
