package com.example.a1project.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;

public class MainScreenController extends SceneController {

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
