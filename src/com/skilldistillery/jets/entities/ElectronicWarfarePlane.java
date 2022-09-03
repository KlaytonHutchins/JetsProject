package com.skilldistillery.jets.entities;

public class ElectronicWarfarePlane extends Airplane{
	
	public ElectronicWarfarePlane(String model, double speed, int range, long price) {
		super.setModel(model);
		super.setSpeed(speed);
		super.setRange(range);
		super.setPrice(price);
	}
	
	public void conductEWMission() {
		
	}
	
}
