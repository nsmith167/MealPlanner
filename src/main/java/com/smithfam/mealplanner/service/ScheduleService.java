package com.smithfam.mealplanner.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.uuid.Generators;
import com.smithfam.mealplanner.model.Schedule;
import com.smithfam.mealplanner.persister.ScheduleRedisRepository;

@Service
public class ScheduleService {

	@Autowired
	ScheduleRedisRepository repository;
	
	public List<Schedule> getSchedules() {
		List<Schedule> schedules = new ArrayList<Schedule>();
		this.repository.findAll().forEach(schedules::add);
		return schedules;
	}
	
	public void addSchedule(Schedule schedule) {
		schedule.setId(Generators.randomBasedGenerator().generate().toString());
		this.repository.save(schedule);
	}
	
	public void updateSchedule(Schedule schedule) {
		this.repository.save(schedule);
	}
	
	public Optional<Schedule> getSchedule(String id) {
		return this.repository.findById(id);
	}
	
	public void removeRecipe(String id) {
		this.repository.deleteById(id);
	}
}
