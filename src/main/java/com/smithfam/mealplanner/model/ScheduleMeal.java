package com.smithfam.mealplanner.model;

public class ScheduleMeal {
	private String day;
	private Recipe recipe;
	
	/**
	 * @param day
	 * @param recipe
	 */
	public ScheduleMeal(String day, Recipe recipe) {
		this.day = day;
		this.recipe = recipe;
	}
	
	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}

	/**
	 * @return the recipe
	 */
	public Recipe getRecipe() {
		return recipe;
	}

	/**
	 * @param recipe the recipe to set
	 */
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

}
