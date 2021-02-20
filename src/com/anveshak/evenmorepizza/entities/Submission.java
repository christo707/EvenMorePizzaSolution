package com.anveshak.evenmorepizza.entities;

import java.util.List;

public class Submission {
	
	private int totalDeliveries;
	private List<Delivery> deliveries;
	
	public Submission() {
		super();
	}

	public Submission(int totalDeliveries, List<Delivery> deliveries) {
		super();
		this.totalDeliveries = totalDeliveries;
		this.deliveries = deliveries;
	}

	public int getTotalDeliveries() {
		return totalDeliveries;
	}

	public void setTotalDeliveries(int totalDeliveries) {
		this.totalDeliveries = totalDeliveries;
	}

	public List<Delivery> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	@Override
	public String toString() {
		return "Submission [totalDeliveries=" + totalDeliveries + ", deliveries=" + deliveries + "]";
	}
	
}
