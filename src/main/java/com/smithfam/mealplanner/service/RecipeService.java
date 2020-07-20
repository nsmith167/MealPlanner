package com.smithfam.mealplanner.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.uuid.Generators;
import com.smithfam.mealplanner.model.Recipe;
import com.smithfam.mealplanner.persister.RecipeJSONRepository;

@Service
public class RecipeService {
	
	@Autowired
	RecipeJSONRepository jsonRepository;
	
	public List<Recipe> getRecipes() {
		return this.jsonRepository.getRecipes();
	}
	
	public void addRecipe(Recipe recipe) throws JsonGenerationException, JsonMappingException, IOException {
		recipe.setId(Generators.randomBasedGenerator().generate().toString());
		this.jsonRepository.addRecipe(recipe);
	}

	public Recipe getRecipe(String id) {
		return this.jsonRepository.getRecipe(id);
	}

	public void updateRecipe(Recipe recipe) throws JsonGenerationException, JsonMappingException, IOException {
		this.jsonRepository.updateRecipe(recipe);
	}
	
	public void removeRecipe(String id) throws JsonGenerationException, JsonMappingException, IOException {
		this.jsonRepository.removeRecipe(id);
	}
}
