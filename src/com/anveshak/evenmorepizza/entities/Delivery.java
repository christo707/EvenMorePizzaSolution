package com.anveshak.evenmorepizza.entities;

import java.util.ArrayList;
import java.util.List;

public class Delivery {
	
	private int teamSize;
	private List<Integer> pizzas;
	
	public Delivery() {
		this.teamSize = 0;
		this.pizzas = new ArrayList<>();
	}
	
	public Delivery(int teamSize, List<Integer> pizzas) {
		super();
		this.teamSize = teamSize;
		this.pizzas = pizzas;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public List<Integer> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Integer> pizzas) {
		this.pizzas = pizzas;
	}

	@Override
	public String toString() {
		return "Delivery [teamSize=" + teamSize + ", pizzas=" + pizzas + "]";
	}
	
}
