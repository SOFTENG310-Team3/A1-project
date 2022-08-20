package com.example.a1project.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;

public class MainScreenController extends SceneController {

	public void addTask(ActionEvent event) throws IOException {
		showNewTaskPopup(event);
	}
	
	public void showAllTasks() {
		
	}
}
