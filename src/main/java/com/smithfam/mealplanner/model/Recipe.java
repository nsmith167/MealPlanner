package com.smithfam.mealplanner.model;

public class Recipe {
	private String name;
	private String instructions;
	private String ingredients;
	private String id;
	
	/**
	 * @param instructions
	 * @param ingredients
	 */
	public Recipe(String instructions, String ingredients, String id) {
		this.instructions = instructions;
		this.ingredients = ingredients;
		this.setId(id);
	}
	
	/**
	 * Dummy for JSON
	 */
	public Recipe() {}
	
	/**
	 * @return the instructions
	 */
	public String getInstructions() {
		return instructions;
	}
	/**
	 * @param instructions the instructions to set
	 */
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	/**
	 * @return the ingredients
	 */
	public String getIngredients() {
		return ingredients;
	}
	/**
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	
}
