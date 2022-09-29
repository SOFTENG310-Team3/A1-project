package com.example.a1project;

public enum AchievementMetric {
	TASKS_COMPLETE{
		@Override
		public String toString() {
			return "TASKS_COMPLETE";
		}
	},
	TASKS_COMPLETE_ON_TIME{
		@Override
		public String toString() {
			return "TASKS_COMPLETE_ON_TIME";
		}
	}
}
