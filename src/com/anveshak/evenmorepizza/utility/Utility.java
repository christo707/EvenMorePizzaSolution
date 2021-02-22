package com.anveshak.evenmorepizza.utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.anveshak.evenmorepizza.entities.Delivery;
import com.anveshak.evenmorepizza.entities.EvenMorePizza;
import com.anveshak.evenmorepizza.entities.Pizza;
import com.anveshak.evenmorepizza.entities.Submission;

public class Utility {

	public static EvenMorePizza readInput(String filename) {
		System.out.println("-----------------------------------File Read Begin--------------------------");
		EvenMorePizza evenMorePizza = new EvenMorePizza();
		File file = new File("input\\" + filename);
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		String firstLine = sc.nextLine();
		String[] firstLineSplit = firstLine.split(" ");

		evenMorePizza.setAvailablePizza(Integer.valueOf(firstLineSplit[0]));
		evenMorePizza.setTeamOfTwo(Integer.valueOf(firstLineSplit[1]));
		evenMorePizza.setTeamOfThree(Integer.valueOf(firstLineSplit[2]));
		evenMorePizza.setTeamOfFour(Integer.valueOf(firstLineSplit[3]));
		
		List<Pizza> pizzas = new ArrayList<>();
		int idx = 0;
		while (sc.hasNextLine()) {
			Pizza p = new Pizza();
			String[] pizzaSplit = sc.nextLine().split(" ");
			p.setTotalIngredeients(Integer.valueOf(pizzaSplit[0]));
			p.setIndex(idx);
			List<String> ings = new ArrayList<>();
			for(int i = 1; i < pizzaSplit.length; i++)
				ings.add(pizzaSplit[i]);
			p.setIngredients(ings);
			idx++;
			pizzas.add(p);
		}
		pizzas.sort((p1, p2) ->  {
			if(p1.getIngredients().size() > p2.getIngredients().size()) 
				return -1;
			else if(p1.getIngredients().size() < p2.getIngredients().size())
				return 1;
			else return 0;
		});
		evenMorePizza.setPizzas(pizzas);
		System.out.println("-----------------------------------File Read End--------------------------");
		return evenMorePizza;
	}
	
	public static void writeOutput(Submission submission, String filename) {
		System.out.println("-----------------------------------File Write Begin--------------------------");
		try {
			File outputfile = new File("output\\" + filename + "_output.txt");
			FileWriter out = new FileWriter(outputfile);
			BufferedWriter bw = new BufferedWriter(out);
			bw.write(Integer.toString(submission.getTotalDeliveries()));
		    for(Delivery d : submission.getDeliveries()) {
		    	bw.newLine();
		    	bw.write(Integer.toString(d.getTeamSize()));
	        	 for(int i = 0; i < d.getPizzas().size(); i++) {
	        		 bw.write(" ");
	        		 bw.write(Integer.toString(d.getPizzas().get(i)));
	        	 }
		    }
			bw.close();
			out.close();
	         System.out.println("File created successfully");
	      }
	      catch (IOException e) {
	    	  e.printStackTrace();
	      }
		System.out.println("-----------------------------------File Write End--------------------------");
	}

}
