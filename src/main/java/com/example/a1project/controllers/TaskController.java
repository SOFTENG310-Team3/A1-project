package com.example.a1project.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;


public class TaskController extends SceneController implements Initializable {

	@FXML
	public ComboBox<String> repeatComboBox;
	@FXML
	public ComboBox<String> categoryComboBox;
	
	ObservableList<String> categoryList = FXCollections.observableArrayList("Work", "School", "Home");
	ObservableList<String> repeatList = FXCollections.observableArrayList("Never","Daily","Weekly","Monthly", "Yearly");
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		categoryComboBox.setItems(categoryList);
		repeatComboBox.setItems(repeatList);
	}
	
	public void toggleTimeButton(ActionEvent event) {
   // TODO document why this method is empty
 }
	
}
