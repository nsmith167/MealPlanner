package com.smithfam.mealplanner.model;

public enum RecipeTypeEnum {
	BREAKFAST,
	AM_SNACK,
	LUNCH,
	PM_SNACK,
	DINNER,
	NIGHT_SNACK;
	
	@Override
	public String toString() {
		String stringValue = "";
		switch(this) {
			case BREAKFAST:
				stringValue = "Breakfast";
				break;
			case AM_SNACK:
				stringValue = "AM Snack";
				break;
			case LUNCH:
				stringValue = "Lunch";
				break;
			case PM_SNACK:
				stringValue = "PM Snack";
				break;
			case DINNER:
				stringValue = "Dinner";
				break;
			case NIGHT_SNACK:
				stringValue = "Night Snack";
				break;
		}
		return stringValue;
	}
}
