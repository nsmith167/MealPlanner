package com.smithfam.mealplanner.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.uuid.Generators;
import com.smithfam.mealplanner.model.Recipe;
import com.smithfam.mealplanner.persister.RecipeRedisRepository;

@Service
public class RecipeService {
	
	@Autowired
	RecipeRedisRepository repository;
	
	public List<Recipe> getRecipes() {
		List<Recipe> recipes = new ArrayList<Recipe>();
		this.repository.findAll().forEach(recipes::add);
		return recipes;
	}
	
	public void addRecipe(Recipe recipe) throws JsonGenerationException, JsonMappingException, IOException {
		recipe.setId(Generators.randomBasedGenerator().generate().toString());
		this.repository.save(recipe);
	}

	public Optional<Recipe> getRecipe(String id) {
		return this.repository.findById(id);
	}

	public void updateRecipe(Recipe recipe) throws JsonGenerationException, JsonMappingException, IOException {
		this.repository.save(recipe);
	}
	
	public void removeRecipe(String id) throws JsonGenerationException, JsonMappingException, IOException {
		this.repository.deleteById(id);
	}
}
