package com.example.a1project.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.a1project.Task;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainScreenController extends SceneController implements Initializable {
	
    @FXML
    private GridPane currentTaskGridPane;

    @FXML
    private GridPane completedTaskGridPane;
    
    @FXML
    private StackPane darkOverlay;
    
    ObservableList<Task> currentTasks = FXCollections.observableArrayList();
	ObservableList<Task> completedTasks = FXCollections.observableArrayList();
	
	ObservableMap<Task, AnchorPane> currentTaskAnchors = FXCollections.observableHashMap();
	ObservableMap<Task, AnchorPane> completedTaskAnchors = FXCollections.observableHashMap();
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// Consider adding listeners to the ObservableLists here (e.g: onChanged) to react whenever changes are made
		// Achieved by using:
		
		// currentTasks.addListener(new ListChangeListener<Task>() { }});
	}
	
	
	/**
	 * Called onClick by addTaskButton in FXML
	 */
	public void addNewTask(ActionEvent event) throws IOException {
		TaskController taskController = showNewTaskPopup(event);
		taskController.setMainScreenController(this);
		this.getDarkOverlay().setVisible(true);
	}
	
	/**
	 * Unimplemented. Called by showAllTasksButton in FXML
	 */
	public void showAllTasks() {
		// TODO: remove sorting filters and show all tasks
	}
	
	/**
	 * Add created task to current tasks. Called from Task screen by TaskController
	 * @param task Task to add
	 */
	public void addTaskToList(Task task) {
		currentTasks.add(task);
		newCurrentTaskDisplay(task);
	}
	
	public void saveTaskToList(int taskIndex, Task editedTask, boolean isCompleted) {
		
		if(isCompleted) {
			Task oldTask = completedTasks.get(taskIndex);
			
			completedTasks.set(taskIndex, editedTask);
			updateCompletedTaskDisplay(oldTask, editedTask, taskIndex);
		} else {
			Task oldTask = currentTasks.get(taskIndex);
			
			currentTasks.set(taskIndex, editedTask);
			updateCurrentTaskDisplay(oldTask, editedTask, taskIndex);
		}
	}
	
	
	/**
	 * Complete task, remove from current tasks to completed tasks list
	 * @param task Task that is completed
	 */
	public void completeTask(Task task) {
		removeFromCurrentTask(task);
		currentTasks.remove(task);
		
		newCompletedTaskDisplay(task);
		completedTasks.add(task);
	}
	
	public int getTaskIndex(Task task) {
		if(task.isCompleted()) {
			return completedTasks.indexOf(task);
		} else {
			return currentTasks.indexOf(task);
		}
	}
	
	public StackPane getDarkOverlay() {
		return darkOverlay;
	}
	
	private void updateCurrentTaskDisplay(Task oldTask, Task task, int taskIndex) {
		AnchorPane anchor = setupTaskItem(task);
		AnchorPane oldTaskAnchor = currentTaskAnchors.get(oldTask);
		
		currentTaskGridPane.getChildren().remove(oldTaskAnchor);
		currentTaskAnchors.remove(oldTask);
		currentTaskGridPane.add(anchor, 0, taskIndex);
		currentTaskAnchors.put(task, anchor);
	}
	
	private void updateCompletedTaskDisplay(Task oldTask, Task task, int taskIndex) {
		AnchorPane anchor = setupTaskItem(task);
		AnchorPane oldTaskAnchor = completedTaskAnchors.get(oldTask);
		
		completedTaskGridPane.getChildren().remove(oldTaskAnchor);
		completedTaskAnchors.remove(oldTask);
		completedTaskGridPane.add(anchor, 0, taskIndex);
		completedTaskAnchors.put(task, anchor);
	}
	
	private void newCurrentTaskDisplay(Task task) {
		AnchorPane anchor = setupTaskItem(task);
		
		// Add to column 0 of GridPane
		currentTaskGridPane.add(anchor, 0, currentTaskGridPane.getRowCount());
		currentTaskAnchors.put(task, anchor);
	}
	
	private void newCompletedTaskDisplay(Task task) {
		
		AnchorPane anchor = setupTaskItem(task);
		
		// Add to column 0 of GridPane
		completedTaskGridPane.add(anchor, 0, completedTaskGridPane.getRowCount());
		completedTaskAnchors.put(task, anchor);
	}
	
	private void removeFromCurrentTask(Task task) {
		int taskIndex = currentTasks.indexOf(task);
		if (taskIndex == -1) {
			return;
		}
		AnchorPane currentTaskAnchor = currentTaskAnchors.get(task);
		currentTaskGridPane.getChildren().remove(currentTaskAnchor);
		currentTaskAnchors.remove(task);
	}
	
	
	
	private AnchorPane setupTaskItem(Task task){
		try {
			FXMLLoader fxmlloader = new FXMLLoader();
			fxmlloader.setLocation(getClass().getResource("/com/example/a1project/SingleTaskDisplay.fxml"));
			AnchorPane anchor = fxmlloader.load();
			
			SingleTaskDisplayController taskDisplay = fxmlloader.getController();
			taskDisplay.setData(task);
			taskDisplay.setMainScreen(this);
			
			return anchor;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
