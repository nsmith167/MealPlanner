package com.smithfam.mealplanner.persister;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smithfam.mealplanner.model.Recipe;

@Repository
public class DummyPersister {
	
	private List<Recipe> recipes;
	
	@Autowired
	public DummyPersister() {
		this.recipes = new ArrayList<Recipe>();
	}
	
	public List<Recipe> getRecipes() {
		return this.recipes;
	}
	
	public void addRecipe(Recipe recipe) {
		this.recipes.add(recipe);
	}
}
