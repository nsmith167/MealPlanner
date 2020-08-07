package com.smithfam.mealplanner.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.smithfam.mealplanner.model.RecipeTypeEnum;

@RestController
public class RecipeTypeEndpoint {

	@RequestMapping(value = "/recipetypes", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getRecipes() {
		List<String> recipeTypes = new ArrayList<String>(RecipeTypeEnum.values().length);
		for (RecipeTypeEnum type: RecipeTypeEnum.values()) {
			recipeTypes.add(type.toString());
		}
		return recipeTypes;
	}
}
