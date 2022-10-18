package com.example.a1project;

import com.example.a1project.achievement.Achievement;
import com.example.a1project.achievement.AchievementMetric;
import com.example.a1project.controllers.TaskController;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestSuite {
	
	// Achievement Class Tests
	
	private Achievement ach;
	
	@Before
	public void setUpAchievements() {
		
		String description = "Complete 10 tasks";
		boolean isUnlocked = false;
		AchievementMetric metric = AchievementMetric.TASKS_COMPLETE;
		int requiredVal = 10;
		
		ach = new Achievement(description, isUnlocked, metric, requiredVal);
		
	}
	
	@Test
	public void testAchievementConstructor() {
		
		assertEquals(ach.getDescription(),"Complete 10 tasks");
		assertFalse(ach.getIsUnlocked());
		assertEquals(ach.getMetric(),AchievementMetric.TASKS_COMPLETE);
		assertEquals(ach.getRequiredMetricVal(),10);
		
	}

	@Test
	public void testDateParsing(){
		assertFalse(TaskController.dateIsValid("29/02/2051"));
		assertTrue(TaskController.dateIsValid("28/02/2051"));

		assertFalse(TaskController.dateIsValid("20/05/2002"));
		assertFalse(TaskController.dateIsValid("23-02-2051"));
		assertFalse(TaskController.dateIsValid("3/2/2051"));
		assertTrue(TaskController.dateIsValid("12/12/2051"));
	}
	

}
