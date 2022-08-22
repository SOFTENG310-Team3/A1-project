package com.example.a1project.controllers;

import com.example.a1project.Achievement;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CardViewController  {

    @FXML
    private Label achievementDescription;
    
    public void setData(Achievement achievement) {
    	achievementDescription.setText(achievement.getDescription());
    }
}

