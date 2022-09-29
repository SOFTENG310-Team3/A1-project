package com.example.a1project;

public class Achievement {
	
	private final String description;
	private boolean isUnlocked;
	private final AchievementMetric metric;
	private final int requiredMetricVal;
	

	public Achievement(String description, boolean isUnlocked, AchievementMetric metric, int requiredMetricVal) {
		this.description = description;
		this.isUnlocked = isUnlocked;
		this.metric = metric;
		this.requiredMetricVal = requiredMetricVal;
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
	
	public void updateAchievement(AchievementMetric metric, int currentMetric) {
		if(this.metric == metric){
			if(currentMetric >= requiredMetricVal){
				isUnlocked = true;
			}
		}
	}

	@Override
	public String toString() {
		return description + "," + isUnlocked + "," + metric.toString() + "," + requiredMetricVal;
	}
}
