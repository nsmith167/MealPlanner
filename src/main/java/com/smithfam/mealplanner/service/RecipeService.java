package com.smithfam.mealplanner.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public void addRecipe(Recipe recipe) {
		recipe.setId(Generators.randomBasedGenerator().generate().toString());
		this.repository.save(recipe);
	}

	public Optional<Recipe> getRecipe(String id) {
		return this.repository.findById(id);
	}

	public void updateRecipe(Recipe recipe) {
		this.repository.save(recipe);
	}
	
	public void removeRecipe(String id) {
		this.repository.deleteById(id);
	}
}
