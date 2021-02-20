package com.anveshak.evenmorepizza;

import java.util.ArrayList;
import java.util.List;

import com.anveshak.evenmorepizza.entities.Delivery;
import com.anveshak.evenmorepizza.entities.EvenMorePizza;
import com.anveshak.evenmorepizza.entities.Pizza;
import com.anveshak.evenmorepizza.entities.Submission;
import com.anveshak.evenmorepizza.utility.Utility;

public class Solution {
	
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		//String filename = "a_example" "b_little_bit_of_everything.in" "c_many_ingredients.in" "d_many_pizzas.in" "e_many_teams.in";
		String filename = "c_many_ingredients.in";
		EvenMorePizza evenMorePizza = Utility.readInput(filename);
		Submission result = solve(evenMorePizza);
		Utility.writeOutput(result, filename);
		
		long endTime = System.nanoTime();

		long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
		
		System.out.println("Time taken: " + (duration / 1000000));
	}
	
	private static Submission solve(EvenMorePizza evenMorePizza) {
		Submission submission = new Submission();
		List<Delivery> allDeliveries = new ArrayList<>();
		int pizza = evenMorePizza.getAvailablePizza();
		double totalTeams = evenMorePizza.getTeamOfTwo() + evenMorePizza.getTeamOfThree() + evenMorePizza.getTeamOfFour();
		double teamsFed = 0;
		int pizzaFed = 0;
		System.out.println(evenMorePizza.getTeamOfFour());
		int t4 = Math.min(pizza / 4, evenMorePizza.getTeamOfFour());
		int t3 = Math.min((pizza - t4 * 4) / 3, evenMorePizza.getTeamOfThree());
		int t2 = Math.min((pizza - t4 * 4 - t3 * 3) / 2, evenMorePizza.getTeamOfTwo());
		int lef = pizza - t4 * 4 - t3 * 3 - t2 * 2;
//		System.out.println("Teams: " + t4 + " " + t3 + " " + t2 + " " + lef);
//		while(lef > 0) {
//	
//			t4--;
//			t3++;
//			t2++;
//			lef = pizza - t4 * 4 - t3 * 3 - t2 * 2;
//		}
		System.out.println("Total Pizza: " + pizza);
		System.out.println("Teams: " + t4 + " " + t3 + " " + t2 + " " + lef);
		System.out.println("Feeding Team of 4:");
		for(int i = 0; i < t4; i++) {
			Delivery delivery = getMyPizzas(evenMorePizza, 4);
			allDeliveries.add(delivery);
			teamsFed++;
			pizzaFed += 4;
			System.out.println("Processed : " + ((teamsFed/totalTeams) * 100) + "% Pizza Fed: " + pizzaFed + " Pizza Remaining: " + evenMorePizza.getPizzas().size());
		}
		
		System.out.println("Feeding Team of 3:");
		for(int i = 0; i < t3; i++) {
			Delivery delivery = getMyPizzas(evenMorePizza, 3);
			allDeliveries.add(delivery);
			teamsFed++;
			pizzaFed += 3;
			System.out.println("Processed : " + ((teamsFed/totalTeams) * 100) + "% Pizza Fed: " + pizzaFed + " Pizza Remaining: " + evenMorePizza.getPizzas().size());
		}
		
		System.out.println("Feeding Team of 2:");
		for(int i = 0; i < t2; i++) {
			Delivery delivery = getMyPizzas(evenMorePizza, 2);
			allDeliveries.add(delivery);
			teamsFed++;
			pizzaFed += 2;
			System.out.println("Processed : " + ((teamsFed/totalTeams) * 100) + "% Pizza Fed: " + pizzaFed + " Pizza Remaining: " + evenMorePizza.getPizzas().size());
		}
		
		submission.setTotalDeliveries(allDeliveries.size());
		submission.setDeliveries(allDeliveries);
		
		
		return submission;
	}


	private static Delivery getMyPizzas(EvenMorePizza evenMorePizza, int type) {
		Delivery delivery = new Delivery();
		delivery.setTeamSize(type);
		List<Pizza> pizzas = evenMorePizza.getPizzas();
		delivery.getPizzas().add(pizzas.get(0).getIndex());
		Pizza firstPizza = pizzas.remove(0);
		List<String> ingUsed = firstPizza.getIngredients(); 
		for(int i = 1; i < type; i++) {
			Pizza bestOption = getBestOptionFromRemainingPizzas(pizzas, ingUsed);
			delivery.getPizzas().add(bestOption.getIndex());
			ingUsed.addAll(bestOption.getIngredients());
			pizzas.removeIf(p -> p.getIndex() == bestOption.getIndex());
		}
		evenMorePizza.setPizzas(pizzas);
		
		return delivery;
	}

	private static Pizza getBestOptionFromRemainingPizzas(List<Pizza> pizzas, List<String> ingUsed) {
		long minScore = Long.MAX_VALUE;
		Pizza bestOption = null;
		for(int i = 0; i < pizzas.size(); i++) {
			long score = pizzas.get(i).getIngredients().stream().filter(ing -> ingUsed.contains(ing)).count();
			if(score < minScore) {
				minScore = score;
				bestOption = pizzas.get(i);
			}
		}
//		Pizza bestOption = pizzas.stream().sorted((p1, p2) -> {
//			long p1Score = p1.getIngredients().stream().filter(ing -> ingUsed.contains(ing)).count();
//			long p2Score = p2.getIngredients().stream().filter(ing -> ingUsed.contains(ing)).count();
//			return p1Score > p2Score ? -1 : (p1Score < p2Score) ? 1 : 0;
//		}).findFirst().get();
		return bestOption;
	}

//	public static Submission sampleOutput() {
//		Delivery d1 = new Delivery(2, new int[] {1, 4}); 
//		Delivery d2 = new Delivery(3, new int[] {0, 2, 3});
//		List<Delivery> deliveries = new ArrayList<>();
//		deliveries.add(d1);
//		deliveries.add(d2);
//		
//		Submission submission = new Submission();
//		submission.setTotalDeliveries(2);
//		submission.setDeliveries(deliveries);
//		
//		return submission;
//	}

}
