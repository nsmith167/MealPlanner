package com.smithfam.mealplanner.persister;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smithfam.mealplanner.model.Schedule;

@Repository
public interface ScheduleRedisRepository extends CrudRepository<Schedule, String> {}
