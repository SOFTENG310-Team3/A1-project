package com.example.a1project;

public class Task {

	private String description;
	private String location;
	private String category;
	private String frequency;
	private String dueDate;
	private String dueTime;
	
	private int priority;
	
	private boolean isCompleted;
	
	/**
	 * @param description
	 * @param location
	 * @param category
	 * @param frequency
	 * @param dueDate
	 * @param dueTime
	 * @param priority
	 */
	public Task(String description, String location, String category, String frequency, String dueDate, String dueTime,
			int priority) {
		super();
		this.description = description;
		this.location = location;
		this.category = category;
		this.frequency = frequency;
		this.dueDate = dueDate;
		this.dueTime = dueTime;
		this.priority = priority;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the frequency
	 */
	public String getFrequency() {
		return frequency;
	}

	/**
	 * @param frequency the frequency to set
	 */
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	/**
	 * @return the dueDate
	 */
	public String getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * @return the dueTime
	 */
	public String getDueTime() {
		return dueTime;
	}

	/**
	 * @param dueTime the dueTime to set
	 */
	public void setDueTime(String dueTime) {
		this.dueTime = dueTime;
	}

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * @return the isCompleted
	 */
	public boolean isCompleted() {
		return isCompleted;
	}

	/**
	 * completes the task
	 */
	public void completeTask() {
		this.isCompleted = true;
	}
	
}
