package com.example.a1project.controllers;

import java.io.IOException;

import com.example.a1project.Task;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class MainScreenController extends SceneController {
	
    @FXML
    private GridPane currentTaskGridPane;

    @FXML
    private GridPane completedTaskGridPane;
    
	public void addTask(ActionEvent event) throws IOException {
		showNewTaskPopup(event);
	}
	
	public void showAllTasks() {
		
	}
	
	private AnchorPane setupTaskItem(Task task) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader();
		fxmlloader.setLocation(getClass().getResource("/com/example/a1project/SingleTaskDisplay.fxml"));
		AnchorPane anchor = fxmlloader.load();
		
		SingleTaskDisplayController taskDisplay = fxmlloader.getController();
		taskDisplay.setData(task);
		
		return anchor;
	}
}
