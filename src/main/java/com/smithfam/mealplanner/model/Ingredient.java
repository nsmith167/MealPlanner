package com.smithfam.mealplanner.model;

public class Ingredient {
	private String name;
	private String quantity;
	private String unit;
	
	public Ingredient(String name, String quantity, String unit) {
		this.name = name;
		this.quantity = quantity;
		this.unit = unit;
	}
	
	/**
	 * Dummy for JSON
	 */
	public Ingredient() {}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
}
