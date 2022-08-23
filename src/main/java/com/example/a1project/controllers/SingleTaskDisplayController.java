package com.example.a1project.controllers;

import com.example.a1project.Task;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class SingleTaskDisplayController {

	Task task;
	
    @FXML
    private AnchorPane baseAnchorPane;

    @FXML
    private CheckBox taskCheckBox;

    @FXML
    private Label taskNameLabel;
    
    @FXML
    private Tooltip descriptionTooltip;

    @FXML
    private Label dueDateLabel;

    @FXML
    private Label dueTimeLabel;

    @FXML
    private Label priorityLabel;

    @FXML
    private Button editButton;
    
    @FXML
    void editTask(ActionEvent event) {
    	//TODO go to edit task scene with task information already in the scene
    }

    @FXML
    void taskCompleted(ActionEvent event) {
    	//TODO update list with completed task in the "completed" section
    	if (!this.task.isCompleted()) {
    		mainScreen.completeTask(this.task);
    		this.task.completeTask();
    	}
    }
    
    private MainScreenController mainScreen;
    
    public void setData(Task task) {
    	
    	this.task = task;
    	
    	taskNameLabel.setText(task.getName()); //TODO Add task name in add task scene and task scene controller
    	
    	descriptionTooltip.setText(task.getDescription());
    	
    	dueDateLabel.setText(task.getDueDate());
    	
    	dueTimeLabel.setText(task.getDueTime());
    	
    	String priority = String.valueOf(task.getPriority());
    	priorityLabel.setText(priority);
    }
    
    public void setMainScreen(MainScreenController mainScreen) {
    	this.mainScreen = mainScreen;
    }
}

