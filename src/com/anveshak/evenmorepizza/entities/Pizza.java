package com.anveshak.evenmorepizza.entities;

import java.util.List;

public class Pizza {

	private int index;
	private int totalIngredeients;
	private List<String> ingredients;

	public Pizza() {
		super();
	}

	public Pizza(int index, int totalIngredeients, List<String> ingredients) {
		super();
		this.index = index;
		this.totalIngredeients = totalIngredeients;
		this.ingredients = ingredients;
	}

	public int getTotalIngredeients() {
		return totalIngredeients;
	}

	public void setTotalIngredeients(int totalIngredeients) {
		this.totalIngredeients = totalIngredeients;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "Pizza [index=" + index + ", totalIngredeients=" + totalIngredeients + ", ingredients=" + ingredients
				+ "]";
	}

}
