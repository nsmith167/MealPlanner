package com.smithfam.mealplanner.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.smithfam.mealplanner.model.Recipe;
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
	public Optional<Recipe> getRecipe(@PathVariable String id) {
		return this.recipeService.getRecipe(id);
	}
	
	
	@RequestMapping(value = "/recipe", method = RequestMethod.POST)
	@ResponseBody
	public Recipe addRecipe(@RequestBody Recipe recipe) {	
		this.recipeService.addRecipe(recipe);
		return recipe;
	}
	
	@RequestMapping(value = "/recipe/bulk", method = RequestMethod.POST)
	@ResponseBody
	public List<Recipe> addAllRecipes(@RequestBody List<Recipe> recipes) {	
		for (Recipe recipe: recipes) {
			this.recipeService.addRecipe(recipe);
		}		
		return recipes;
	}
	
	@RequestMapping(value = "/recipe/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Recipe editRecipe(@RequestBody Recipe recipe) {	
		this.recipeService.updateRecipe(recipe);
		return recipe;
	}
	
	@RequestMapping(value = "/recipe/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void removeRecipe(@PathVariable String id) {	
		this.recipeService.removeRecipe(id);
	}
	
}
