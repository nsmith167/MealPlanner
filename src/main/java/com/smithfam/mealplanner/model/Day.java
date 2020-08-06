package com.smithfam.mealplanner.model;

public class Day {
	private String day;
	private Recipe breakfast;
	private Recipe amSnack;
	private Recipe lunch;
	private Recipe pmSnack;
	private Recipe dinner;
	private Recipe nightSnack;
	
	/**
	 * @return the breakfast
	 */
	public Recipe getBreakfast() {
		return breakfast;
	}
	/**
	 * @param breakfast the breakfast to set
	 */
	public void setBreakfast(Recipe breakfast) {
		this.breakfast = breakfast;
	}
	/**
	 * @return the amSnack
	 */
	public Recipe getAmSnack() {
		return amSnack;
	}
	/**
	 * @param amSnack the amSnack to set
	 */
	public void setAmSnack(Recipe amSnack) {
		this.amSnack = amSnack;
	}
	/**
	 * @return the lunch
	 */
	public Recipe getLunch() {
		return lunch;
	}
	/**
	 * @param lunch the lunch to set
	 */
	public void setLunch(Recipe lunch) {
		this.lunch = lunch;
	}
	/**
	 * @return the pmSnack
	 */
	public Recipe getPmSnack() {
		return pmSnack;
	}
	/**
	 * @param pmSnack the pmSnack to set
	 */
	public void setPmSnack(Recipe pmSnack) {
		this.pmSnack = pmSnack;
	}
	/**
	 * @return the dinner
	 */
	public Recipe getDinner() {
		return dinner;
	}
	/**
	 * @param dinner the dinner to set
	 */
	public void setDinner(Recipe dinner) {
		this.dinner = dinner;
	}
	/**
	 * @return the nightSnack
	 */
	public Recipe getNightSnack() {
		return nightSnack;
	}
	/**
	 * @param nightSnack the nightSnack to set
	 */
	public void setNightSnack(Recipe nightSnack) {
		this.nightSnack = nightSnack;
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
	 * Set the recipe for a specific time of the day
	 * @param recipe
	 * @param type
	 */
	public void setRecipeAtTime(Recipe recipe, RecipeTypeEnum type) {
		switch(type) {
			case BREAKFAST:
				this.setBreakfast(recipe);
				break;
			case AM_SNACK:
				this.setAmSnack(recipe);
				break;
			case LUNCH:
				this.setLunch(recipe);
				break;
			case PM_SNACK:
				this.setPmSnack(recipe);
				break;
			case DINNER:
				this.setDinner(recipe);
				break;
			case NIGHT_SNACK:
				this.setNightSnack(recipe);
				break;
		}
	}

}
