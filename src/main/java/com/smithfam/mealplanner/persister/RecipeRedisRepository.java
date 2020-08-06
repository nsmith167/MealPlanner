package com.smithfam.mealplanner.persister;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.smithfam.mealplanner.model.Recipe;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

@Repository
public class RecipeRedisRepository implements IRecipeRepository {
	private JedisPool pool;
	private Logger logger = LoggerFactory.getLogger(RecipeRedisRepository.class);
	
	public RecipeRedisRepository() {
		try {
	        URI redisUri = new URI(System.getenv("REDISCLOUD_URL"));
	        pool = new JedisPool(new JedisPoolConfig(),
	                redisUri.getHost(),
	                redisUri.getPort(),
	                Protocol.DEFAULT_TIMEOUT,
	                redisUri.getUserInfo().split(":",2)[1]);
		} catch (URISyntaxException e) {
		    logger.error(e.getMessage());
		}
	}

	@Override
	public List<Recipe> getRecipes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRecipe(Recipe recipe) {
		Jedis jedis = this.pool.getResource();
	}

	@Override
	public Recipe getRecipe(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeRecipe(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateRecipe(Recipe updatedRecipe) {
		// TODO Auto-generated method stub

	}

}
