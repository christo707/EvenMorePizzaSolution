package com.anveshak.evenmorepizza.entities;

import java.util.List;

public class EvenMorePizza {
	private int availablePizza;
	private int teamOfTwo;
	private int teamOfThree;
	private int teamOfFour;
	private List<Pizza> pizzas;

	public EvenMorePizza() {
		super();
	}

	public EvenMorePizza(int availablePizza, int teamOfTwo, int teamOfThree, int teamOfFour, List<Pizza> pizzas) {
		super();
		this.availablePizza = availablePizza;
		this.teamOfTwo = teamOfTwo;
		this.teamOfThree = teamOfThree;
		this.teamOfFour = teamOfFour;
		this.pizzas = pizzas;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	public int getAvailablePizza() {
		return availablePizza;
	}

	public void setAvailablePizza(int availablePizza) {
		this.availablePizza = availablePizza;
	}

	public int getTeamOfTwo() {
		return teamOfTwo;
	}

	public void setTeamOfTwo(int teamOfTwo) {
		this.teamOfTwo = teamOfTwo;
	}

	public int getTeamOfThree() {
		return teamOfThree;
	}

	public void setTeamOfThree(int teamOfThree) {
		this.teamOfThree = teamOfThree;
	}

	public int getTeamOfFour() {
		return teamOfFour;
	}

	public void setTeamOfFour(int teamOfFour) {
		this.teamOfFour = teamOfFour;
	}
	
	public int getTotalPeople() {
		return 2 * teamOfTwo + 3 * teamOfThree + 4 * teamOfFour;
	}

	@Override
	public String toString() {
		return "EvenMorePizza [availablePizza=" + availablePizza + ", teamOfTwo=" + teamOfTwo + ", teamOfThree=" + teamOfThree
				+ ", teamOfFour=" + teamOfFour + ", pizzas=" + pizzas + "]";
	}

}
