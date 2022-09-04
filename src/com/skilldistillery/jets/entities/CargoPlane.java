package com.skilldistillery.jets.entities;

public class CargoPlane extends Airplane implements CargoCarrier{

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	public void loadCargo() {
		
	}
	
}
