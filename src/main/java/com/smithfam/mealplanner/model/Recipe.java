package com.smithfam.mealplanner.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Recipe {
	private String name;
	private String instructions;
	private List<Ingredient> ingredients;
	private long id;
	
	/**
	 * @param instructions
	 * @param ingredients
	 */
	public Recipe(String instructions, List<Ingredient> ingredients, long id) {
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
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	/**
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(List<Ingredient> ingredients) {
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
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	
}
