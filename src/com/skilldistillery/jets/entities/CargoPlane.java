package com.skilldistillery.jets.entities;

public class CargoPlane extends Airplane implements CargoCarrier{

	public CargoPlane(String model, double speed, int range, long price) {
		super.setModel(model);
		super.setSpeed(speed);
		super.setRange(range);
		super.setPrice(price);

	}
	
	public void loadCargo() {
		
	}
	
}