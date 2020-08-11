package com.smithfam.mealplanner.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.smithfam.mealplanner.model.Day;
import com.smithfam.mealplanner.model.Recipe;
import com.smithfam.mealplanner.model.RecipeTypeEnum;
import com.smithfam.mealplanner.model.Schedule;
import com.smithfam.mealplanner.service.RecipeService;
import com.smithfam.mealplanner.service.ScheduleService;

@RestController
public class ScheduleController {
	
	@Autowired
	ScheduleService scheduleService;
	
	@Autowired
	RecipeService recipeService;
	
	@RequestMapping(value = "/schedule", method = RequestMethod.GET)
	@ResponseBody
	public Schedule getWeeklyRecipes() throws Exception {
		List<Schedule> schedules = this.scheduleService.getSchedules();
		Schedule schedule;
		if (schedules == null || schedules.size() == 0) {
			schedule = this.getNewWeeklyRecipes();
		}
		else {
			schedule = schedules.get(0);
		}
		return schedule;
	}
	
	@RequestMapping(value = "/schedule/new", method = RequestMethod.GET)
	@ResponseBody
	public Schedule getNewWeeklyRecipes() throws Exception {
		Schedule schedule = this.generateMealSchedule(this.recipeService.getRecipes());
		List<Schedule> existingSchedules = this.scheduleService.getSchedules();
		if (existingSchedules.size() > 0) {
			schedule.setId(existingSchedules.get(0).getId());
			this.scheduleService.updateSchedule(schedule);
		}
		else {
			this.scheduleService.addSchedule(schedule);
		}
		return schedule;
	}

	private Schedule generateMealSchedule(List<Recipe> recipes) throws Exception {
		Schedule weeklyRecipes = new Schedule();
		if (recipes.size() > 0) {
			Random indexGenerator = new Random();
			//Loop through days of the week
			for(int i = 0; i < 7; i++) {
				ArrayList<Integer> takenNumbers = new ArrayList<Integer>();
				Day dailyRecipes = new Day();
				dailyRecipes.setDay(this.getDayFromNumber(i));
				//Loop through meal times
				for(RecipeTypeEnum type: RecipeTypeEnum.values()) {
					Integer number = indexGenerator.nextInt(recipes.size());
					while(takenNumbers.contains(number) || (recipes.get(number).getRecipeType() != type)) {				
						number = indexGenerator.nextInt(recipes.size()); 
					}
					dailyRecipes.setRecipeAtTime(recipes.get(number), type);					
					takenNumbers.add(number);
					//Allow recipes to be re-used within a day if necessary
					if (takenNumbers.size() == recipes.size()) {
						takenNumbers.clear();
					}
				}
				
				weeklyRecipes.addDay(dailyRecipes);
				
			}
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
