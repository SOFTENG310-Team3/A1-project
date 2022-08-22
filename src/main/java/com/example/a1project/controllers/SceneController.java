package com.example.a1project.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SceneController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchToMainScreen(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("../MainScreen.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToRewards(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("../Rewards.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void showNewTaskPopup(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("../Task.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Stage popup = new Stage();
		popup.initModality(Modality.APPLICATION_MODAL);
		popup.initOwner(stage);
		popup.initStyle(StageStyle.UNDECORATED);
		scene = new Scene(root);
		popup.setScene(scene);
		popup.show();
	}
	
	public void closeTaskPopup(ActionEvent event) {
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
	}
}