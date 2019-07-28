package com.smithfam.mealplanner.persister;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class IdJSONRepository {
	private int nextId;
	
	public IdJSONRepository() throws JsonParseException, JsonMappingException, IOException {
		this.loadData();
	}
	
	public long getNextId() {
		return (long)this.nextId;
	}
	
	public void incrementId() throws JsonGenerationException, JsonMappingException, IOException {
		this.nextId++;
		this.saveData();
	}
	
	private void loadData() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		File dataFile = new File("src/main/resources/storage/nextId.json");
		if (dataFile.exists()) {
			this.nextId = mapper.readValue(dataFile, Integer.class);
		}
		else {
			this.nextId = 0;
		}
		
	}
	
	private void saveData() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("src/main/resources/storage/nextId.json"), this.nextId);
	}
}
