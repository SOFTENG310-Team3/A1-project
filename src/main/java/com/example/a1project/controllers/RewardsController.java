package com.example.a1project.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.example.a1project.achievement.Achievement;
import com.example.a1project.achievement.AchievementManager;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class RewardsController extends SceneController implements Initializable {

	@FXML 
	private GridPane gridPane;
	@FXML 
	private Label completedLabel;
	
	int column=0;
	int row=0;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		List<Achievement> achievements = AchievementManager.getAchievements();
		setCount(achievements.size(), AchievementManager.getAchievementsComplete());
		try {
			for (Achievement achievement : achievements) {

				FXMLLoader fxmlloader = new FXMLLoader();
				fxmlloader.setLocation(getClass().getResource("/fxml/SingleAchievement.fxml"));
				AnchorPane anchor = fxmlloader.load();

				CardViewController cardView = fxmlloader.getController();

				cardView.setData(achievement);

				gridPane.add(anchor, column, row++);
				GridPane.setMargin(anchor, new Insets(10));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setCount(int size, int number) {
		completedLabel.setText(number + "/" + size);
		completedLabel.setFont(Font.font(48));
	}
	
}
