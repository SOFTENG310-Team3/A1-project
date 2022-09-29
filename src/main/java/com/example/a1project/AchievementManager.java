package com.example.a1project;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class AchievementManager {
	
	private AchievementManager() {
		
	}
	
	private static ArrayList<Achievement> achievementArray = new ArrayList<>();

	private static int tasksComplete = 0;

	private static int tasksCompleteOnTime = 0;

	private static final String achievementFileName = "txtfiles/Achievements.txt";
	
	public static int getAchievementsComplete() {
		int achievementsComplete = 0;
		for (Achievement ach : achievementArray){
			if (ach.getIsUnlocked()) {
				achievementsComplete++;
			}
		}
		return achievementsComplete;
	}
	
	public static void loadAchievements() throws IOException {
				
		try (BufferedReader br = new BufferedReader(new FileReader(achievementFileName))){
			
			String line;
			tasksComplete = Integer.parseInt(br.readLine());
			tasksCompleteOnTime = Integer.parseInt(br.readLine());
			while((line=br.readLine()) !=null) {
				String[] variable = line.split(",");
				String description = variable[0];
				Boolean isUnlocked = Boolean.parseBoolean(variable[1]);
				AchievementMetric metric = findMetric(variable[2]);
				int required = Integer.parseInt(variable[3]);
				
				achievementArray.add(new Achievement(description, isUnlocked, metric,required));
			}
		} 
	}

	public static void writeAchievements(){
		try (FileWriter writer = new FileWriter(achievementFileName, false)){
			writer.write(tasksComplete + "\n");
			writer.write(tasksCompleteOnTime + "\n");
			for (Achievement ach : achievementArray){
				writer.write(ach.toString() + "\n");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void incrementTasksComplete(boolean onTime){
		tasksComplete++;
		if(onTime)tasksCompleteOnTime++;
		updateAchievements();
	}

	private static void updateAchievements() {
		for (Achievement ach : achievementArray){
			ach.updateAchievement(AchievementMetric.TASKS_COMPLETE, tasksComplete);
			ach.updateAchievement(AchievementMetric.TASKS_COMPLETE_ON_TIME,tasksCompleteOnTime);
		}
		writeAchievements();
	}

	public static AchievementMetric findMetric(String line) {
		
		AchievementMetric metric;
		if(line.equals(AchievementMetric.TASKS_COMPLETE.toString())) {
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
