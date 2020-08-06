package com.smithfam.mealplanner.persister;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smithfam.mealplanner.model.Recipe;

@Repository
public interface RecipeRedisRepository extends CrudRepository<Recipe, String> {}
