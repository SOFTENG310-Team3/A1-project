package com.example.a1project.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.a1project.Utility;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class RewardsController extends SceneController implements Initializable {

	@FXML 
	private ListView<String> achievementList;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String[] achievements = Utility.getAchievementsToList();
		achievementList.getItems().addAll(achievements);
	}
	
}
