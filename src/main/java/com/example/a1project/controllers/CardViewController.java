package com.example.a1project.controllers;

import com.example.a1project.achievement.Achievement;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CardViewController  {

    @FXML
    private Label achievementDescription;

    @FXML
    private ImageView trophyImageView;

    public void setData(Achievement achievement) {
        achievementDescription.setText(achievement.getDescription());
        if(achievement.getIsUnlocked()) setCompletedTrophy();
    }

    public void setCompletedTrophy() {
        Image trophy = new Image(trophyImageView.getImage().getUrl().replaceAll("trophyblank.png", "trophy.png"));
        trophyImageView.setImage(trophy);
    }
}