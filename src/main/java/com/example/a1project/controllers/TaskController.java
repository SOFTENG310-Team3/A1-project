package com.example.a1project.controllers;

import java.net.URL;
import java.util.ResourceBundle;

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
	public TextField taskTextField, locationTextField;
	

	
	ObservableList<String> categoryList = FXCollections.observableArrayList("Work", "School", "Home");
	ObservableList<String> repeatList = FXCollections.observableArrayList("Never","Daily","Weekly","Monthly", "Yearly");
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		categoryComboBox.setItems(categoryList);
		repeatComboBox.setItems(repeatList);
		
	}
	
	
	public void addTask(ActionEvent event) {
		String repeat = repeatComboBox.getValue();
		String category = categoryComboBox.getValue();
		String description = taskTextField.getText();
		System.out.println(description);
		Toggle selectedTime = time.getSelectedToggle();
		System.out.println(selectedTime.equals(amToggle));
		
	}
	
	
}
