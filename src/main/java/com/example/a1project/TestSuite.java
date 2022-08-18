package com.example.a1project;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestSuite {
	
	// Achievement Class Tests
	
	private Achievement ach;
	
	@Before
	public void setUpAchievements() {
		
		String description = "Complete 10 tasks";
		boolean isUnlocked = false;
		AchievementMetric metric = AchievementMetric.TASKS_COMPLETE;
		int requiredVal = 10;
		int currentVal = 0;
		
		ach = new Achievement(description, isUnlocked, metric, requiredVal, currentVal);
		
	}
	
	@Test
	public void testAcheivementConstructor() {
		
		assertEquals(ach.getDescription(),"Complete 10 tasks");
		assertEquals(ach.getIsUnlocked(),false);
		assertEquals(ach.getMetric(),AchievementMetric.TASKS_COMPLETE);
		assertEquals(ach.getRequiredMetricVal(),10);
		assertEquals(ach.getCurrentMetricVal(),0);
		
	}
	
	@Test
	public void testSetCurrentMetricVal() {
		
		ach.setCurrentMetricVal(2);
		assertEquals(ach.getCurrentMetricVal(),2);
		
	}
	
	@Test
	public void testSetisUnlocked() {
	
		ach.setIsUnlocked(true);
		assertEquals(ach.getIsUnlocked(),true);
		
	}
	

}
