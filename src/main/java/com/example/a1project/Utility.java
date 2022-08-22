package com.example.a1project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Utility {
	
	private Utility() {
		
	}
	
	private static ArrayList<Achievement> achievementArray = new ArrayList<>();
	private static int number=0;
	
	public static int getDone() {
		return number;
	}
	
	public static void loadAchievements() throws IOException {
				
		try (BufferedReader br = new BufferedReader(new FileReader("txtfiles/Achievements.txt"))){
			
			String line;
			while((line=br.readLine()) !=null) {
				String[] variable = line.split(",");
				String description = variable[0];
				Boolean isUnlocked = Boolean.parseBoolean(variable[1]);
				if (Boolean.TRUE.equals(isUnlocked)) {
					number++;
				}
				AchievementMetric metric = findMetric(variable[2]);
				int  required = Integer.parseInt(variable[3]);
				int current = Integer.parseInt(variable[4]);
				
				achievementArray.add(new Achievement(description, isUnlocked, metric,required, current));
			}
		} 
	}
	
	public static AchievementMetric findMetric(String line) {
		
		AchievementMetric metric;
		if(line.equals("TASKS_COMPLETED")) {
			metric = AchievementMetric.TASKS_COMPLETE;
		} else {
			metric = AchievementMetric.TASKS_COMPLETE_ON_TIME;
		}
		
		return metric;
	}
	
	public static List<Achievement> getAchievements() {
		return achievementArray;
	}
	
}
