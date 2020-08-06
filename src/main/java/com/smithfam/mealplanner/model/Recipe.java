package com.smithfam.mealplanner.model;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Recipe")
public class Recipe {
	private String name;
	private String instructions;
	private String ingredients;
	private String id;
	private RecipeTypeEnum recipeType;
	
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

	/**
	 * @return the recipeType
	 */
	public RecipeTypeEnum getRecipeType() {
		return recipeType;
	}

	/**
	 * @param recipeType the recipeType to set
	 */
	public void setRecipeType(RecipeTypeEnum recipeType) {
		this.recipeType = recipeType;
	}
	
	
}
