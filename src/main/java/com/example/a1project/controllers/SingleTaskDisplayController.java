package com.example.a1project.controllers;

import java.io.IOException;

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
    private Button deleteButton;
    
    @FXML
    void editTask(ActionEvent event) throws IOException {
    	TaskController taskController = mainScreen.showEditTaskPopup(event);
		taskController.setMainScreenController(mainScreen);
		taskController.setTaskIndex(mainScreen.getTaskIndex(task));
		taskController.setEditingTask(task);
		setEditTaskScene(taskController);
    }

    @FXML
    void taskCompleted(ActionEvent event) {
    	//TODO update list with completed task in the "completed" section
    	if (!this.task.isCompleted()) {
    		mainScreen.completeTask(this.task);
    		this.task.completeTask();
    	}
    }

    @FXML
    void deleteTask(ActionEvent event) {
        mainScreen.deleteTask(task);
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
    
    public void setEditTaskScene(TaskController taskController) {
    	
    	taskController.taskNameTextField.setText(task.getName());
    	taskController.taskDescriptionTextField.setText(task.getDescription());
    	taskController.locationTextField.setText(task.getLocation());
    	taskController.categoryComboBox.getSelectionModel().select(task.getCategory());
    	taskController.dayTextField.setText(task.getDueDate());
    	taskController.repeatComboBox.getSelectionModel().select(task.getFrequency());
    	
    	switch(task.getPriority()) {
    	case 1:
    		taskController.lowToggle.selectedProperty().set(true);
    		break;
    	case 2:
    		taskController.medToggle.selectedProperty().set(true);
    		break;
    	case 3:
    		taskController.highToggle.selectedProperty().set(true);
    		break;
    	default:
    		break;
    	}
    	
    	String[] dueTime = task.getDueTime().split(" ");
    	taskController.timeTextField.setText(dueTime[0]);
    	
    	switch(dueTime[1]) {
    	case "am":
    		taskController.amToggle.selectedProperty().set(true);
    		break;
    	case "pm":
    		taskController.pmToggle.selectedProperty().set(true);
    		break;
    	default:
    		break;
    	}
    	
    	
    }
}

