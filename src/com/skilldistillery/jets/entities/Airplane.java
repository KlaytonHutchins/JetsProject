package com.skilldistillery.jets.entities;

public abstract class Airplane {
	
	private String model;
	private double speed;
	private int range;
	private long price;
	
	public Airplane(String model, double speed, int range, long price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}
	
	public void fly() {
		double timeOfFlight = range / speed;
		System.out.println("Model: " + model + ", Speed:" + speed + ", Range:" + range +  ", Price:" + price + " is flying for " + timeOfFlight + " hours");
	}
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
}
