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
import com.smithfam.mealplanner.model.ScheduleMeal;
import com.smithfam.mealplanner.service.RecipeService;

@RestController
@RequestMapping(value="/recipes")
public class RecipeController {
	
	@Autowired
	RecipeService recipeService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public List<Recipe> getRecipes() {
		return this.recipeService.getRecipes();
	}
	
	@RequestMapping(value = "/recipe/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Recipe getRecipe(@PathVariable String id) {
		return this.recipeService.getRecipe(id);
	}
	
	
	@RequestMapping(value = "/recipe", method = RequestMethod.POST)
	@ResponseBody
	public Recipe addRecipe(@RequestBody Recipe recipe) throws JsonGenerationException, JsonMappingException, IOException {	
		this.recipeService.addRecipe(recipe);
		return recipe;
	}
	
	@RequestMapping(value = "/recipe/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Recipe editRecipe(@RequestBody Recipe recipe) throws JsonGenerationException, JsonMappingException, IOException {	
		this.recipeService.updateRecipe(recipe);
		return recipe;
	}
	
	@RequestMapping(value = "/recipe/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void removeRecipe(@PathVariable String id) throws JsonGenerationException, JsonMappingException, IOException {	
		this.recipeService.removeRecipe(id);
	}
	
	@RequestMapping(value = "/schedule", method = RequestMethod.GET)
	@ResponseBody
	public List<ScheduleMeal> getWeeklyRecipes() throws Exception {
		List<ScheduleMeal> recipes = this.generateMealSchedule(this.recipeService.getRecipes());		
		return recipes;
	}

	private List<ScheduleMeal> generateMealSchedule(List<Recipe> recipes) throws Exception {
		List<ScheduleMeal> weeklyRecipes = new ArrayList<ScheduleMeal>();
		Random indexGenerator = new Random();
		ArrayList<Integer> takenNumbers = new ArrayList<Integer>();
		for(int i = 0; i < 7; i++) {
			Integer number = indexGenerator.nextInt(recipes.size() - 1);
			while(takenNumbers.contains(number)) {
				number = indexGenerator.nextInt(recipes.size() - 1); 
			}
			weeklyRecipes.add(new ScheduleMeal(this.getDayFromNumber(i), recipes.get(number)));
			takenNumbers.add(number);
		}
		return weeklyRecipes;
	}
	
	private String getDayFromNumber(int dayNum) throws Exception {
		if (dayNum < 0 || dayNum > 6) {
			throw new Exception("Invalid day number passed in to RecipeController.getDayFromNumber()."
					+ "\nNumber must be between 0 and 6.");
		}
		else {
			switch(dayNum) {
				case(0): return "Sunday";
				case(1): return "Monday";
				case(2): return "Tuesday";
				case(3): return "Wednesday";
				case(4): return "Thursday";
				case(5): return "Friday";
				case(6): return "Saturday";
				default: return "";
			}
		}			
	}
}
