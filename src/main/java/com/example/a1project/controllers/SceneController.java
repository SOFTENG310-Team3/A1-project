package com.example.a1project.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
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
	
	public TaskController showNewTaskPopup(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/com/example/a1project/Task.fxml"));
		
		root = loader.load();
		
		TaskController taskController = loader.getController();
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Stage popup = new Stage();
		popup.initModality(Modality.APPLICATION_MODAL);
		popup.initOwner(stage);
		popup.initStyle(StageStyle.TRANSPARENT);
		scene = new Scene(root);
		scene.setFill(Color.TRANSPARENT);
		popup.setScene(scene);
		popup.show();
		
		return taskController;
	}
	
	public TaskController showEditTaskPopup(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/com/example/a1project/Task.fxml"));
		
		root = loader.load();
		
		TaskController taskController = loader.getController();
		taskController.addTaskButton.setVisible(false);
		taskController.addTaskButton.setManaged(false);
		taskController.saveTaskButton.setVisible(true);
		taskController.saveTaskButton.setDisable(false);
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Stage popup = new Stage();
		popup.initModality(Modality.APPLICATION_MODAL);
		popup.initOwner(stage);
		popup.initStyle(StageStyle.TRANSPARENT);
		scene = new Scene(root);
		scene.setFill(Color.TRANSPARENT);
		popup.setScene(scene);
		popup.show();
		
		return taskController;
	}
	
}