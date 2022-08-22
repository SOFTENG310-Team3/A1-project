package com.example.a1project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class SingleTaskDisplayController {

    @FXML
    private AnchorPane baseAnchorPane;

    @FXML
    private HBox vBox;

    @FXML
    private CheckBox taskCheckBox;

    @FXML
    private Label taskNameLabel;

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

    }

    @FXML
    void taskCompleted(ActionEvent event) {

    }
}

