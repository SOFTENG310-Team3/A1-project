package com.example.a1project.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

import com.example.a1project.Task;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


public class TaskController extends SceneController implements Initializable {

	@FXML
	public Button addTaskButton, saveTaskButton;
	@FXML
	public ComboBox<String> repeatComboBox;
	@FXML
	public ComboBox<String> categoryComboBox;
	@FXML
	public ToggleButton pmToggle, amToggle, lowToggle, medToggle, highToggle;
	@FXML
	public Stage stage;
	
	public ToggleGroup time, priority;
	public TextField taskNameTextField, taskDescriptionTextField, locationTextField,dayTextField,timeTextField;
	
	private MainScreenController mainScreen;



	ObservableList<String> categoryList = FXCollections.observableArrayList("Work", "School", "Home");
	ObservableList<String> repeatList = FXCollections.observableArrayList("Never","Daily","Weekly","Monthly", "Yearly");

	public String name;
	public String description;
	public String repeat;
	public String category;
	public String dueDate;
	public String dueTime;
	public String location;
	public int priorityNum;
	
	public int taskIndex = -1;
	public Task editingTask;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		categoryComboBox.setItems(categoryList);
		repeatComboBox.setItems(repeatList);

	}
	
	public void setMainScreenController(MainScreenController mainScreen) {
		this.mainScreen = mainScreen;
	}
	
	public boolean checkTask() {
		boolean pass = true;
		String fail = "-fx-border-color:red;";
		resetFailure();

		
		this.repeat = repeatComboBox.getValue();
		if (repeat == null) {
			repeatComboBox.setStyle(fail);
			pass = false;
		}
		
		
		this.category = categoryComboBox.getValue();
		if (category == null) {
			categoryComboBox.setStyle(fail);
			pass = false;
		}

		this.name = taskNameTextField.getText();
		if (name.equals("")) {
			taskNameTextField.setStyle(fail);
			pass = false;
		}
		
		this.description = taskDescriptionTextField.getText();
		if (description.equals("")) {
			taskDescriptionTextField.setStyle(fail);
			pass = false;
		}

		
		this.location = locationTextField.getText();
		if (location.equals("")) {
			locationTextField.setStyle(fail);
			pass = false;
		}
		
		
		this.priorityNum = getPriorityToggle();
		if ( priorityNum == 0) {
			lowToggle.setStyle(fail);
			medToggle.setStyle(fail);
			highToggle.setStyle(fail);
			pass = false;
		}

		
		this.dueDate = dayTextField.getText();
		if (!dateIsValid(dueDate)) {
			pass = false;
			dayTextField.setStyle(fail);
		}
		
		this.dueTime = getTimeString();
		
		return pass;
	}


	public void addTask(ActionEvent event) {
		
		boolean pass = checkTask();
		
		if(pass) {
			Task task = new Task(name, description, location, category, repeat, dueDate, dueTime, priorityNum);
			mainScreen.addTaskToCurrentList(task);
		}
		
	}
	
	public void saveTask(ActionEvent event) {
		
		boolean pass = checkTask();
		
		if(pass) {
			editingTask.setName(name);
			editingTask.setDescription(description);
			editingTask.setLocation(location);
			editingTask.setCategory(category);
			editingTask.setFrequency(repeat);
			editingTask.setDueDate(dueDate);
			editingTask.setDueTime(dueTime);
			editingTask.setPriority(priorityNum);
			
			boolean isCompleted = editingTask.getIsCompleted();
			
			mainScreen.saveTaskToList(taskIndex,editingTask, isCompleted );
		}
	}

	private void resetFailure() {
		String base = "-fx-border-color: #77B3D4;";
		repeatComboBox.setStyle(base);
		categoryComboBox.setStyle(base);
		taskNameTextField.setStyle(base);
		taskDescriptionTextField.setStyle(base);
		locationTextField.setStyle(base);
		lowToggle.setStyle(base);
		medToggle.setStyle(base);
		highToggle.setStyle(base);
		dayTextField.setStyle(base);
		timeTextField.setStyle(base);
		pmToggle.setStyle(base);
		amToggle.setStyle(base);
	}

	public String getTimeString() {
		
		String fail = "-fx-border-color:red;";
		StringBuilder stringBuilder = new StringBuilder();
		String dueHour = timeTextField.getText();
		
		if (isHourValid(dueHour)) {
			stringBuilder.append(dueHour);
		} else {
			timeTextField.setStyle(fail);
		}	
		
		
		Toggle selectedTime = time.getSelectedToggle();

		if (selectedTime == null) {
			pmToggle.setStyle(fail);
			amToggle.setStyle(fail);
		} else if (selectedTime.equals(amToggle)) {
			stringBuilder.append(" am");
		} else if (selectedTime.equals(pmToggle)) {
			stringBuilder.append(" pm");
		}
		
		return stringBuilder.toString();
	}
	
	/**
	 * Check if the supplied date string is a valid date and is not before today
	 * @param dueDate a date sting supplied by the user
	 * @return whether the date is valid and after/or today.
	 */
	public static boolean dateIsValid(String dueDate ){

		String[] dayCheck = dueDate.split("/");
		
		if (dayCheck.length != 3) {
			return false;
		}
		
		String date = dayCheck[2] + "-" + dayCheck[1] + "-" + dayCheck[0];
		LocalDate due;
		try {
			due = LocalDate.parse(date);
		} catch (DateTimeParseException e) {
			return false;
		}
		LocalDate today = LocalDate.now();

		return !today.isAfter(due);

	}

	public int getPriorityToggle() {

		Toggle selectedPriority = priority.getSelectedToggle();

		int priorityNum = 0;
		if (selectedPriority != null) {

			if (selectedPriority.equals(highToggle)) {
				priorityNum = 3;
			} else if (selectedPriority.equals(medToggle)) {
				priorityNum = 2;
			} else if (selectedPriority.equals(lowToggle)) {
				priorityNum = 1;
			}
		}

		return priorityNum;
	}
	
	public boolean isHourValid(String dueHour) {
		String[] timeCheck = dueHour.split(":");

		if (timeCheck.length == 2) {
			int hour = Integer.parseInt(timeCheck[0]);
			int minute = Integer.parseInt(timeCheck[1]);
			
			if (hour > 0 && hour < 13 && minute > -1 && minute < 60 ) {
				return true;
			} 

		}
		return false;
	}
	
	public int getTaskIndex() {
		return taskIndex;
	}
	
	public void setTaskIndex(int taskIndex) {
		this.taskIndex = taskIndex;
	}
	
	public Task getEditingTask() {
		return editingTask;
	}
	
	public void setEditingTask(Task editingTask) {
		this.editingTask = editingTask;
	}
	
	public void closeTaskPopup(ActionEvent event) {
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
		
		mainScreen.getDarkOverlay().setVisible(false);
	}
}
