package com.smithfam.mealplanner.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
import com.smithfam.mealplanner.model.Day;
import com.smithfam.mealplanner.model.Recipe;
import com.smithfam.mealplanner.model.RecipeTypeEnum;
import com.smithfam.mealplanner.model.Schedule;
import com.smithfam.mealplanner.service.RecipeService;
import com.smithfam.mealplanner.service.ScheduleService;

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
	public Optional<Recipe> getRecipe(@PathVariable String id) {
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
	
}
