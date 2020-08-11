package com.smithfam.mealplanner.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.redis.core.RedisHash;

import com.fasterxml.uuid.Generators;

@RedisHash("Schedule")
public class Schedule {

	private String id;
	private List<Day> days;
	
	public Schedule(List<Day> days) {
		this.id = Generators.randomBasedGenerator().generate().toString();
		this.days = days;
	}
	
	public Schedule() {
		this.days = new ArrayList<Day>(7);
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the days
	 */
	public List<Day> getDays() {
		return days;
	}

	/**
	 * @param days the days to set
	 */
	public void setDays(List<Day> days) {
		this.days = days;
	}
	
	/**
	 * @param day
	 */
	public void addDay(Day day) {
		this.days.add(day);
	}

}
