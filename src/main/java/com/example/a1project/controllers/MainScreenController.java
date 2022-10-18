package com.example.a1project.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.a1project.achievement.AchievementManager;
import com.example.a1project.Task;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Toggle;

public class MainScreenController extends SceneController implements Initializable {
	
    @FXML
    private GridPane currentTaskGridPane;

    @FXML
    private GridPane completedTaskGridPane;
    
    @FXML
    private StackPane darkOverlay;
	public ToggleButton workToggle, schoolToggle, homeToggle, lowToggle, medToggle, highToggle;
	public ToggleGroup category;
	public ToggleGroup priority;
	
	public String[] currentFilters = new String[3];
	
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
		if(removeFromCurrentTask(task)){
			newCompletedTaskDisplay(task);
			AchievementManager.incrementTasksComplete(true);
		}
	}
	
	public void sortByCategory(ActionEvent event) {

		String selectedCategory = getCategoryToggle();

		switch (selectedCategory) {
		case "Work":
			workToggle.getStyleClass().add("selected-toggle");
			schoolToggle.getStyleClass().remove("selected-toggle");
			homeToggle.getStyleClass().remove("selected-toggle");
			currentFilters[0] = "Work";
			displayFilteredTasks(currentFilters, currentTasks, currentTaskAnchors);
			displayFilteredTasks(currentFilters, completedTasks, completedTaskAnchors);
			break;
		case "School":
			workToggle.getStyleClass().remove("selected-toggle");
			schoolToggle.getStyleClass().add("selected-toggle");
			homeToggle.getStyleClass().remove("selected-toggle");
			currentFilters[0] = "School";
			displayFilteredTasks(currentFilters, currentTasks, currentTaskAnchors);
			displayFilteredTasks(currentFilters, completedTasks, completedTaskAnchors);
			break;
		case "Home":
			workToggle.getStyleClass().remove("selected-toggle");
			schoolToggle.getStyleClass().remove("selected-toggle");
			homeToggle.getStyleClass().add("selected-toggle");
			currentFilters[0] = "Home";
			displayFilteredTasks(currentFilters, currentTasks, currentTaskAnchors);
			displayFilteredTasks(currentFilters, completedTasks, completedTaskAnchors);
			break;
		case "All":
			workToggle.getStyleClass().remove("selected-toggle");
			schoolToggle.getStyleClass().remove("selected-toggle");
			homeToggle.getStyleClass().remove("selected-toggle");
			currentFilters[0] = null;
			displayFilteredTasks(currentFilters, currentTasks, currentTaskAnchors);
			displayFilteredTasks(currentFilters, completedTasks, completedTaskAnchors);
			break;
		default:
			break;
		}
	}
	
	
	public void sortByPriority(ActionEvent event) {
		String selectedPriority = getPriorityToggle();

		switch (selectedPriority) {
		case "Low":
			lowToggle.getStyleClass().add("selected-toggle");
			medToggle.getStyleClass().remove("selected-toggle");
			highToggle.getStyleClass().remove("selected-toggle");
			currentFilters[1] = "1";
			displayFilteredTasks(currentFilters, currentTasks, currentTaskAnchors);
			displayFilteredTasks(currentFilters, completedTasks, completedTaskAnchors);
			break;
		case "Medium":
			lowToggle.getStyleClass().remove("selected-toggle");
			medToggle.getStyleClass().add("selected-toggle");
			highToggle.getStyleClass().remove("selected-toggle");
			currentFilters[1] = "2";
			displayFilteredTasks(currentFilters, currentTasks, currentTaskAnchors);
			displayFilteredTasks(currentFilters, completedTasks, completedTaskAnchors);
			break;
		case "High":
			lowToggle.getStyleClass().remove("selected-toggle");
			medToggle.getStyleClass().remove("selected-toggle");
			highToggle.getStyleClass().add("selected-toggle");
			currentFilters[1] = "3";
			displayFilteredTasks(currentFilters, currentTasks, currentTaskAnchors);
			displayFilteredTasks(currentFilters, completedTasks, completedTaskAnchors);
			break;
		case "All":
			lowToggle.getStyleClass().remove("selected-toggle");
			medToggle.getStyleClass().remove("selected-toggle");
			highToggle.getStyleClass().remove("selected-toggle");
			currentFilters[1] = null;
			displayFilteredTasks(currentFilters, currentTasks, currentTaskAnchors);
			displayFilteredTasks(currentFilters, completedTasks, completedTaskAnchors);
			break;
		default:
			break;
		}
	}
	
	
	private String getPriorityToggle() {
		Toggle selectedPriority = priority.getSelectedToggle();

		String priority = "All";
		if (selectedPriority != null) {

			if (selectedPriority.equals(lowToggle)) {
				priority = "Low";
			} else if (selectedPriority.equals(medToggle)) {
				priority = "Medium";
			} else if (selectedPriority.equals(highToggle)) {
				priority = "High";
			}
		}
		
		return priority;
	}
	
	public void displayFilteredTasks(String[] filters, ObservableList<Task> taskList, ObservableMap<Task, AnchorPane> taskAnchorPanes) {
		ArrayList<Task> tasksToDisplay = new ArrayList<Task>();
		for(Task task: taskList) {
			tasksToDisplay.add(task);
		}
		
		for(String filter: filters) {
			if(filter != null) {
				tasksToDisplay.removeAll(getTasksWithoutFilter(filter,tasksToDisplay));
				}
			}
		
		AnchorPane currentTaskAnchor;
		for(Task task: taskList) {
			currentTaskAnchor = taskAnchorPanes.get(task);
			if(tasksToDisplay.contains(task)) {
				setTaskVisible(currentTaskAnchor);
			} else {
				setTaskInvisible(currentTaskAnchor);
			}
		}
	}

		public ArrayList<Task> getTasksWithoutFilter(String filter, ArrayList<Task> currentTasks) {
			ArrayList<Task> filteredOutTasks = new ArrayList<Task>();
			for (Task task : currentTasks) {
				if (!(task.getCategory().equals(filter) ||String.valueOf(task.getPriority()).equals(filter) || task.getDueDate().equals((filter)))) {
					filteredOutTasks.add(task);
				}
			}
			return filteredOutTasks;
		}
	
	public void setTaskVisible(AnchorPane taskAnchor) {
		taskAnchor.setVisible(true);
		taskAnchor.setManaged(true);
	}
	
	public void setTaskInvisible(AnchorPane taskAnchor) {
		taskAnchor.setVisible(false);
		taskAnchor.setManaged(false);
	}

	public String getCategoryToggle() {
		
		Toggle selectedCategory = category.getSelectedToggle();

		String category = "All";
		if (selectedCategory != null) {

			if (selectedCategory.equals(workToggle)) {
				category = "Work";
			} else if (selectedCategory.equals(schoolToggle)) {
				category = "School";
			} else if (selectedCategory.equals(homeToggle)) {
				category = "Home";
			}
		}
		
		return category;
	}
	
	/**
	 * Delete task, remove from tasks list
	 * @param task Task to be deleted
	 */
	public void deleteTask(Task task) {
		if(currentTasks.contains(task)) {
			removeFromCurrentTask(task);
			currentTasks.remove(task);
		} else {
			removeFromCompletedTask(task);
			completedTasks.remove(task);
		}
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
		
		displayFilteredTasks(currentFilters,currentTasks,currentTaskAnchors);
		
	}
	
	private void newCompletedTaskDisplay(Task task) {
		
		AnchorPane anchor = setupTaskItem(task);
		
		// Add to column 0 of GridPane
		completedTaskGridPane.add(anchor, 0, completedTaskGridPane.getRowCount());
		completedTaskAnchors.put(task, anchor);

		completedTasks.add(task);
	}
	
	private boolean removeFromCurrentTask(Task task) {
		int taskIndex = currentTasks.indexOf(task);
		if (taskIndex == -1) {
			return false;
		}
		AnchorPane currentTaskAnchor = currentTaskAnchors.get(task);
		currentTaskGridPane.getChildren().remove(currentTaskAnchor);
		currentTaskAnchors.remove(task);
		currentTasks.remove(task);
		return true;
	}

	private void removeFromCompletedTask(Task task) {
		int taskIndex = completedTasks.indexOf(task);
		if (taskIndex == -1) {
			return;
		}
		completedTaskGridPane.getChildren().remove(taskIndex);
	}
	
	
	
	private AnchorPane setupTaskItem(Task task){
		try {
			FXMLLoader fxmlloader = new FXMLLoader();
			fxmlloader.setLocation(getClass().getResource("/fxml/SingleTaskDisplay.fxml"));
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
