package com.example.a1project.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.a1project.Task;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;


public class TaskController extends SceneController implements Initializable {

	@FXML
	public ComboBox<String> repeatComboBox;
	@FXML
	public ComboBox<String> categoryComboBox;
	@FXML
	public ToggleButton pmToggle, amToggle, lowToggle, medToggle, highToggle;
	public ToggleGroup time, priority;
	public TextField taskTextField, locationTextField,dayTextField,timeTextField;



	ObservableList<String> categoryList = FXCollections.observableArrayList("Work", "School", "Home");
	ObservableList<String> repeatList = FXCollections.observableArrayList("Never","Daily","Weekly","Monthly", "Yearly");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		categoryComboBox.setItems(categoryList);
		repeatComboBox.setItems(repeatList);

	}


	public void addTask(ActionEvent event) {

		boolean pass = true;
		String fail = "-fx-border-color:red;";
		resetFailure();

		
		String repeat = repeatComboBox.getValue();
		if (repeat == null) {
			repeatComboBox.setStyle(fail);
			pass = false;
		}
		
		
		String category = categoryComboBox.getValue();
		if (category == null) {
			categoryComboBox.setStyle(fail);
			pass = false;
		}

		
		String description = taskTextField.getText();
		if (description.equals("")) {
			taskTextField.setStyle(fail);
			pass = false;
		}

		
		String location = locationTextField.getText();
		if (location.equals("")) {
			locationTextField.setStyle(fail);
			pass = false;
		}
		
		
		int priorityNum = getPriorityToggle();
		if ( priorityNum == 0) {
			lowToggle.setStyle(fail);
			medToggle.setStyle(fail);
			highToggle.setStyle(fail);
			pass = false;
		}

		
		String dueDate = dayTextField.getText();
		if (!dateIsValid(dueDate)) {
			pass = false;
			dayTextField.setStyle(fail);
		}
		
		
		String dueTime = getTimeString();
		
		if(pass) {
			Task task = new Task(description, location, category, repeat, dueDate, dueTime, priorityNum);
			//MainScreenController.addTask(task)
		}
		
	}

	private void resetFailure() {
		String base = "-fx-border-color: #77B3D4;";
		repeatComboBox.setStyle(base);
		categoryComboBox.setStyle(base);
		taskTextField.setStyle(base);
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
		
		return stringBuilder.toString();;
	}

	public boolean dateIsValid(String dueDate ){

		String[] dayCheck = dueDate.split("/");

		if (dayCheck.length == 3) {
			int year = Integer.parseInt(dayCheck[2]);
			int month =Integer.parseInt(dayCheck[1]);
			int day = Integer.parseInt(dayCheck[0]);

			if ( month > 0 && month < 13 && day > 0 && day < 32 && year > 2021){
				return true;
			}
		}

		return false;
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
}
