package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.entities.Airfield;
import com.skilldistillery.jets.entities.Airplane;
import com.skilldistillery.jets.entities.CargoCarrier;
import com.skilldistillery.jets.entities.CargoPlane;
import com.skilldistillery.jets.entities.CombatReady;
import com.skilldistillery.jets.entities.ElectronicWarfarePlane;
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

		boolean userStillSelecting = true;
		while (userStillSelecting) {
			displayUserMenu();
			int userSelection = sc.nextInt();

			while (userSelection < 1 || userSelection > 10) {
				System.err.print("Invalid entry, please choose a number from 1 - 10: ");
				userSelection = sc.nextInt();
			}

			userStillSelecting = implementUserSelection(userSelection);
		}

		System.out.println("Thank you for visiting the Airfield!");
	}

	public void displayUserMenu() {

		System.out.println("--------------------------------------");
		System.out.println("1. List fleet\n2. Fly all planes\n3. View fastest plane\n4. View plane with longest range"
				+ "\n5. View plane with longest flight time\n6. Load all cargo planes\n7. Dogfight!\n8. Add a plane to Fleet\n9. Remove a plane from Fleet\n10. Quit");
		System.out.println("--------------------------------------");
	}

	public boolean implementUserSelection(int menuNum) {

		switch (menuNum) {
		case 1: {
			return airfield.listFleet();
		}
		case 2: {
			return airfield.flyAllPlanes();
		}
		case 3: {
			return airfield.viewFastestPlane();
		}
		case 4: {
			return airfield.viewPlaneLongestRange();
		}
		case 5: {
			return airfield.viewPlaneLongestFlightTime();
		}
		case 6: {
			return airfield.loadAllCargoPlanes();
		}
		case 7: {
			return airfield.dogfight();
		}
		case 8: {
			return airfield.addPlaneToFleet();
		}
		case 9: {
			return airfield.removePlaneFromFleet();
		}
		case 10: {
			return false;
		}
		default: {
			return true;
		}
		}
	}

}
