package com.smithfam.mealplanner.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusEndpoint {

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String getRecipes() {
		return "I am running, don't worry";
	}
}
