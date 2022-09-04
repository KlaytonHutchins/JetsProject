package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.entities.Airfield;
import com.skilldistillery.jets.entities.Airplane;

public class JetsApplication {
	
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApplication ja = new JetsApplication();
		ja.launch();
	}
	
	public void launch() {
		
		Airfield airfield = new Airfield();
		for (Airplane ap : airfield.fleet) {
			ap.fly();
		}
		displayUserMenu();
		
	}
	
	public void displayUserMenu() {
		System.out.println("1. List fleet\n2. Fly all jets\n3. View fastest jet\n4. View jet with longest range"
		+ "\n5. Load all Cargo Jets\n6. Dogfight!\n7. Add a jet to Fleet\n8. Remove a jet from Fleet\n9. Quit");
	}
	
}
