package com.smithfam.mealplanner.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.smithfam.mealplanner.model.Recipe;
import com.smithfam.mealplanner.service.RecipeService;

@RestController
public class RecipeController {
	
	@Autowired
	RecipeService recipeService;
	
	@RequestMapping(value = "/all-recipes", method = RequestMethod.GET)
	@ResponseBody
	public List<Recipe> getRecipes() {
		return this.recipeService.getRecipes();
	}
	
	@RequestMapping(value = "/recipe/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Recipe getRecipe(@PathVariable long id) {
		return this.recipeService.getRecipe(id);
	}
	
	
	@RequestMapping(value = "/add-recipe", method = RequestMethod.POST)
	@ResponseBody
	public void addRecipe(@RequestBody Recipe recipe) throws JsonGenerationException, JsonMappingException, IOException {	
		this.recipeService.addRecipe(recipe);
	}
	
	@RequestMapping(value = "/next-id", method = RequestMethod.GET)
	@ResponseBody
	public long nextRecipeId() {
		return this.recipeService.getNextRecipeId();
	}
	
	@RequestMapping(value = "/weekly-recipes", method = RequestMethod.GET)
	@ResponseBody
	public List<Recipe> getWeeklyRecipes() {
		List<Recipe> recipes = this.generateMealSchedule(this.recipeService.getRecipes());		
		return recipes;
	}

	private List<Recipe> generateMealSchedule(List<Recipe> recipes) {
		List<Recipe> weeklyRecipes = new ArrayList<Recipe>();
		Random indexGenerator = new Random();
		ArrayList<Integer> takenNumbers = new ArrayList<Integer>();
		for(int i = 0; i < 7; i++) {
			Integer number = indexGenerator.nextInt(recipes.size() - 1);
			while(takenNumbers.contains(number)) {
				number = indexGenerator.nextInt(recipes.size() - 1); 
			}
			weeklyRecipes.add(recipes.get(number));
			takenNumbers.add(number);
		}
		return weeklyRecipes;
	}
}
