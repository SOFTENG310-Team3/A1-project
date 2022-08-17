package com.example.a1project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
	
    @Override
    public void start(Stage stage) throws Exception {
        
    	Parent root = FXMLLoader.load(getClass().getResource("Task.fxml"));
    	Scene scene = new Scene(root);
    	
    	String css = this.getClass().getResource("Task.css").toExternalForm();
    	scene.getStylesheets().add(css);
    	
    	stage.setTitle("My To Do's");
    	//stage.setWidth(1200);
    	//stage.setHeight(800);
    	stage.setResizable(false);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}