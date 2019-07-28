package com.smithfam.mealplanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	
	@RequestMapping("/")
	public String recipeListPage(Model model) {
		return "RecipeList";
	}
	
	@RequestMapping("/newRecipe")
	public String newRecipePage(Model model) {
		return "NewRecipe";
	}
	
	@RequestMapping("/schedule")
	public String schedulePage(Model model) {
		return "SchedulePage";
	}
}
