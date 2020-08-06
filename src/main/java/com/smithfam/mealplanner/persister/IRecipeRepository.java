package com.smithfam.mealplanner.persister;

import java.util.List;

import com.smithfam.mealplanner.model.Recipe;

public interface IRecipeRepository {
	
	public List<Recipe> getRecipes();
	
	public void addRecipe(Recipe recipe);

	public Recipe getRecipe(String id);
	
	public void removeRecipe(String id);
	
	public void updateRecipe(Recipe updatedRecipe);
}
