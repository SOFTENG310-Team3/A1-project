package com.example.a1project;

public class Achievement {
	
	private final String description;
	private boolean isUnlocked;
	private final AchievementMetric metric; 
	private final int requiredMetricVal; 
	private int currentMetricVal; 
	

	public Achievement(String description, boolean isUnlocked, AchievementMetric metric, int requiredMetricVal, int currentMetricVal) {
		this.description = description;
		this.isUnlocked = isUnlocked;
		this.metric = metric;
		this.requiredMetricVal = requiredMetricVal;
		this.currentMetricVal = currentMetricVal;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public boolean getIsUnlocked() {
		return this.isUnlocked;
	}
	
	public AchievementMetric getMetric() {
		return this.metric;
	}
	
	public int getRequiredMetricVal() {
		return this.requiredMetricVal;
	}
	
	public int getCurrentMetricVal () {
		return this.currentMetricVal;
	}
	
	public void setIsUnlocked(boolean status) {
		this.isUnlocked = status;
	}
	
	public void setCurrentMetricVal(int newVal) {
		this.currentMetricVal = newVal;
	}
	

}
