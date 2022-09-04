package com.skilldistillery.jets.entities;

public class FighterJet extends Airplane implements CombatReady{
	
	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	public void fight() {
		
	}
	
}
