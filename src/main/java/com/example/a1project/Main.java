package com.example.a1project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
	
    @Override
    public void start(Stage stage) throws Exception {
        
    	Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
    	Scene scene = new Scene(root);
    	
    	String css = this.getClass().getResource("ToDo.css").toExternalForm();
    	scene.getStylesheets().add(css);
    	
    	stage.setTitle("My To Do's");
    	stage.setWidth(1200);
    	stage.setHeight(800);
    	stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}