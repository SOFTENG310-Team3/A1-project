package com.example.a1project.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.a1project.Task;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainScreenController extends SceneController implements Initializable {
	
    @FXML
    private GridPane currentTaskGridPane;

    @FXML
    private GridPane completedTaskGridPane;
    
    ObservableList<Task> currentTasks = FXCollections.observableArrayList();
	ObservableList<Task> completedTasks = FXCollections.observableArrayList();
    
	public void addTask(ActionEvent event) throws IOException {
		showNewTaskPopup(event);
	}
	
	public void showAllTasks() {
		
	}
	
	private void newCurrentTaskDisplay(Task task) {
		
		AnchorPane anchor = setupTaskItem(task);
		
		currentTaskGridPane.add(anchor, 1, currentTaskGridPane.getRowCount());
	}
	
	private void newCompletedTaskDisplay(Task task) {
		
		AnchorPane anchor = setupTaskItem(task);
		
		completedTaskGridPane.add(anchor, 1, completedTaskGridPane.getRowCount());
	}
	
	
	
	private AnchorPane setupTaskItem(Task task){
		try {
			FXMLLoader fxmlloader = new FXMLLoader();
			fxmlloader.setLocation(getClass().getResource("/com/example/a1project/SingleTaskDisplay.fxml"));
			AnchorPane anchor = fxmlloader.load();
			
			SingleTaskDisplayController taskDisplay = fxmlloader.getController();
			taskDisplay.setData(task);
			
			return anchor;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		currentTasks.addListener(new ListChangeListener<Task>() {
//		    @Override
//		    public void onChanged(Change<? extends Task> changedItems) {
//		    	
//		    	// TODO: update FXML (VBox or ListView) to new tasks
//		    	// updateDisplayLists();
//		    	
//		        // while (changedItems.next()) to access all items changed
//		    }});
//		
//		completedTasks.addListener(new ListChangeListener<Task>() {
//		    @Override
//		    public void onChanged(Change<? extends Task> changedItems) {
//		    	
//		    	// TODO: update FXML (VBox or ListView) to new tasks
//		    	// updateDisplayLists();
//		    }});
		
	}
	
	
	

	/**
	 * Called onClick by FXML addTaskButton
	 */
	public void addNewTask(ActionEvent event) throws IOException {
		TaskController taskController = showNewTaskPopup(event);
		taskController.setMainScreenController(this);
	}
	
	/**
	 * Add created task to current tasks. Called from Task screen by TaskController
	 * @param task Task to add
	 */
	public void addTaskToList(Task task) {
		currentTasks.add(task);
		newCurrentTaskDisplay(task);
	}
	
	
	public void completeTask(Task task) {
		currentTasks.remove(task);
		completedTasks.add(task);
		
		newCompletedTaskDisplay(task);
	}

}
