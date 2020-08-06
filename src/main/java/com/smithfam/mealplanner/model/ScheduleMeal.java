package com.smithfam.mealplanner.model;

public class ScheduleMeal {
	private String day;
	private Recipe recipe;
	private RecipeTypeEnum type;
	
	/**
	 * @param day
	 * @param recipe
	 */
	public ScheduleMeal(String day, Recipe recipe, RecipeTypeEnum type) {
		this.day = day;
		this.recipe = recipe;
		this.setType(type);
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

	/**
	 * @return the type
	 */
	public RecipeTypeEnum getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(RecipeTypeEnum type) {
		this.type = type;
	}

}
