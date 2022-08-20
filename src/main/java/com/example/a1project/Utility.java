package com.example.a1project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class Utility {
	
	private Utility() {
		
	}
	
	private static ArrayList<Achievement> achievementArray = new ArrayList<>();
	
	public static void loadAchievements() throws IOException {
				
		try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/example/a1project/txtfiles/Achievements.txt"))){
			
			String line;
			while((line=br.readLine()) !=null) {
				String[] variable = line.split(",");
				String description = variable[0];
				Boolean isUnlocked = Boolean.parseBoolean(variable[1]);
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
	
	public static String[] getAchievementsToList() {
		
		int size = achievementArray.size();
		String[] achievements = new String[size];
		for(int i=0; i<size; i++) {
			achievements[i] = achievementArray.get(i).getDescription();
		}
		
		return achievements;
	}
	
}
