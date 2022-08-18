package com.example.a1project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestSuite {
	
	// Achievement Class Tests
	
	@Test
	public void testAcheivementConstructor() {
		String description = "Complete 10 tasks";
		boolean isUnlocked = false;
		AchievementMetric metric = AchievementMetric.TASKS_COMPLETE;
		int requiredVal = 10;
		int currentVal = 0;
		
		Achievement ach = new Achievement(description, isUnlocked, metric, requiredVal, currentVal);
		
		assertEquals(ach.getDescription(),description);
		assertEquals(ach.getIsUnlocked(),isUnlocked);
		assertEquals(ach.getMetric(),metric);
		assertEquals(ach.getRequiredMetricVal(),requiredVal);
		assertEquals(ach.getCurrentMetricVal(),currentVal);
	}
	
	@Test
	public void testSetCurrentMetricVal() {
		String description = "Complete 10 tasks";
		boolean isUnlocked = false;
		AchievementMetric metric = AchievementMetric.TASKS_COMPLETE;
		int requiredVal = 10;
		int currentVal = 0;
		
		Achievement ach = new Achievement(description, isUnlocked, metric, requiredVal, currentVal);
	
		ach.setCurrentMetricVal(2);
		
		assertEquals(ach.getCurrentMetricVal(),2);
	}
	
	@Test
	public void testSetisUnlocked() {
		String description = "Complete 10 tasks";
		boolean isUnlocked = false;
		AchievementMetric metric = AchievementMetric.TASKS_COMPLETE;
		int requiredVal = 10;
		int currentVal = 0;
		
		Achievement ach = new Achievement(description, isUnlocked, metric, requiredVal, currentVal);
	
		ach.setIsUnlocked(true);
		
		assertEquals(ach.getIsUnlocked(),true);
	}
	

}
