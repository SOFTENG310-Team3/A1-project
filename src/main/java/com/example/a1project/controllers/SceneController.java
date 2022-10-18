package com.example.a1project.controllers;

import java.io.IOException;
import java.util.Objects;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToMainScreen(ActionEvent event) throws IOException {
        switchToScreen(event, "MainScreen.fxml");
    }

    public void switchToRewards(ActionEvent event) throws IOException {
        switchToScreen(event, "Rewards.fxml");
    }

    public void switchToScreen(ActionEvent event, String fxmlFileName) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/" + fxmlFileName)));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public TaskController showNewTaskPopup(ActionEvent event) throws IOException {

        FXMLLoader loader = setPopupLoader("Task.fxml");

        TaskController taskController = loader.getController();

        showPopup(event);
        return taskController;
    }

    public TaskController showEditTaskPopup(ActionEvent event) throws IOException {

        FXMLLoader loader = setPopupLoader("Task.fxml");

        TaskController taskController = loader.getController();
        taskController.addTaskButton.setVisible(false);
        taskController.addTaskButton.setManaged(false);
        taskController.saveTaskButton.setVisible(true);
        taskController.saveTaskButton.setDisable(false);

        showPopup(event);
        return taskController;
    }

    private FXMLLoader setPopupLoader(String fxmlFileName) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/" + fxmlFileName));
        root = loader.load();
        return loader;
    }

    private void showPopup(ActionEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.initOwner(stage);
        popup.initStyle(StageStyle.TRANSPARENT);
        scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        popup.setScene(scene);
        popup.show();
    }

}