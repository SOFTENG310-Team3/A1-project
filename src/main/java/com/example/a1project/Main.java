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
        
    	Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
    	Scene scene = new Scene(root);
    	
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