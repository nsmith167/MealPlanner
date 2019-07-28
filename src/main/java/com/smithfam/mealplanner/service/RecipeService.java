package com.smithfam.mealplanner.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.smithfam.mealplanner.model.Recipe;
import com.smithfam.mealplanner.persister.IdJSONRepository;
import com.smithfam.mealplanner.persister.RecipeJSONRepository;

@Service
public class RecipeService {
	
	@Autowired
	RecipeJSONRepository jsonRepository;
	
	@Autowired
	IdJSONRepository idRepository;
	
	public List<Recipe> getRecipes() {
		return this.jsonRepository.getRecipes();
	}
	
	public void addRecipe(Recipe recipe) throws JsonGenerationException, JsonMappingException, IOException {
		this.jsonRepository.addRecipe(recipe);
	}

	public Recipe getRecipe(long id) {
		return this.jsonRepository.getRecipe(id);
	}

	public long getNextRecipeId() {
		return this.idRepository.getNextId();
	}
}
