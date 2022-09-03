package com.skilldistillery.jets.entities;

public class FighterJet extends Airplane implements CombatReady{
	
	public FighterJet(String model, double speed, int range, long price) {
		super.setModel(model);
		super.setSpeed(speed);
		super.setRange(range);
		super.setPrice(price);
	}
	
	public void fight() {
		
	}
	
}
