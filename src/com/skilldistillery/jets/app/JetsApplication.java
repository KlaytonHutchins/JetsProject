package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.entities.Airfield;
import com.skilldistillery.jets.entities.Airplane;
import com.skilldistillery.jets.entities.CargoPlane;
import com.skilldistillery.jets.entities.FighterJet;

public class JetsApplication {

	private Scanner sc = new Scanner(System.in);
	private Airfield airfield;

	public static void main(String[] args) {
		JetsApplication ja = new JetsApplication();
		ja.launch();
	}

	public void launch() {

		airfield = new Airfield();
		for (Airplane ap : airfield.fleet) {
			ap.fly();
		}
		boolean userStillSelecting = true;
		while (userStillSelecting) {
			displayUserMenu();
			int userSelection = sc.nextInt();
			while (userSelection < 1 || userSelection > 9) {
				userSelection = sc.nextInt();
			}
			userStillSelecting = implementUserSelection(userSelection);
		}

	}

	public void displayUserMenu() {
		System.out.println("1. List fleet\n2. Fly all planes\n3. View fastest plane\n4. View plane with longest range"
				+ "\n5. Load all cargo planes\n6. Dogfight!\n7. Add a plane to Fleet\n8. Remove a plane from Fleet\n9. Quit");
	}

	public boolean implementUserSelection(int menuNum) {
		switch (menuNum) {
		case 1: {
			for (Airplane ap : airfield.fleet) {
				System.out.println(ap);
				;
			}
			return true;
		}
		case 2: {
			for (Airplane ap : airfield.fleet) {
				ap.fly();
			}
			return true;
		}
		case 3: {
			int idxFastestPlane = 0;
			for (int i = 0; i < airfield.fleet.size(); i++) {
				if ((airfield.fleet.get(i)).getSpeed() > (airfield.fleet.get(idxFastestPlane)).getSpeed()) {
					idxFastestPlane = i;
				}
			}
			System.out.println(airfield.fleet.get(idxFastestPlane));
			return true;
		}
		case 4: {
			int idxLongestRangePlane = 0;
			for (int i = 0; i < airfield.fleet.size(); i++) {
				if ((airfield.fleet.get(i)).getRange() > (airfield.fleet.get(idxLongestRangePlane)).getRange()) {
					idxLongestRangePlane = i;
				}
			}
			System.out.println(airfield.fleet.get(idxLongestRangePlane));
			return true;
		}
		case 5: {
			for (int i = 0; i < airfield.fleet.size(); i++) {
				if ((airfield.fleet.get(i)) instanceof CargoPlane) {
					CargoPlane plane = (CargoPlane) airfield.fleet.get(i);
					plane.loadCargo();
				}
			}
			return true;
		}
		case 6: {
			for (int i = 0; i < airfield.fleet.size(); i++) {
				if ((airfield.fleet.get(i)) instanceof FighterJet) {
					FighterJet plane = (FighterJet) airfield.fleet.get(i);
					plane.fight();
				}
			}
			return true;
		}
		case 7: {

			return true;
		}
		case 8: {

			return true;
		}
		case 9: {
			return false;
		}
		default: {
			return true;
		}
		}
	}

}
