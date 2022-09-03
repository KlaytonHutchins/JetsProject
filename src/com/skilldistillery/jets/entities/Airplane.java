package com.skilldistillery.jets.entities;

public abstract class Airplane {
	
	private String model;
	private double speed;
	private int range;
	private long price;
	
	public Airplane() { }
	
	public void fly() {
		
	}
	
	public double getSpeedInMach() {
		double speedInMach = 0;
		return speedInMach;
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
