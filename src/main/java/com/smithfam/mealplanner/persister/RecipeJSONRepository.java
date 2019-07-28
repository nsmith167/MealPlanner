package com.smithfam.mealplanner.persister;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smithfam.mealplanner.model.Recipe;

@Repository
public class RecipeJSONRepository {
	
	private ArrayList<Recipe> recipes;
	
	public RecipeJSONRepository() throws JsonParseException, JsonMappingException, IOException {
		this.loadData();
	}
	
	public List<Recipe> getRecipes() {
		return this.recipes;
	}
	
	public void addRecipe(Recipe recipe) throws JsonGenerationException, JsonMappingException, IOException {
		this.recipes.add(recipe);
		this.saveData();
	}
	
	private void loadData() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		File dataFile = new File("src/main/resources/storage/recipes.json");
		if (dataFile.exists()) {
			this.recipes = mapper.readValue(dataFile, new TypeReference<ArrayList<Recipe>>() {});
		}
		else {
			this.recipes = new ArrayList<Recipe>();
		}
	}
	
	private void saveData() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("src/main/resources/storage/recipes.json"), this.recipes);
	}

	public Recipe getRecipe(long id) {
		return this.recipes.get((int) id);
	}
}
