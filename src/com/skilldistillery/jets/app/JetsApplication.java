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

		System.out.println("Thanks for visiting the Airfield!");
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
			for (Airplane ap : airfield.fleet) {
				System.out.println(ap);
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
			System.out.println("The fastest plane in the fleet is: " + airfield.fleet.get(idxFastestPlane));
			return true;
		}
		case 4: {
			int idxLongestRangePlane = 0;
			for (int i = 0; i < airfield.fleet.size(); i++) {
				if ((airfield.fleet.get(i)).getRange() > (airfield.fleet.get(idxLongestRangePlane)).getRange()) {
					idxLongestRangePlane = i;
				}
			}
			System.out.println(
					"The plane with the longest range in the fleet is: " + airfield.fleet.get(idxLongestRangePlane));
			return true;
		}
		case 5: {
			int idxLongestFlightTime = 0;
			for (int i = 0; i < airfield.fleet.size(); i++) {
				if ((airfield.fleet.get(i)).getRange()
						/ (airfield.fleet.get(i)).getSpeed() > (airfield.fleet.get(idxLongestFlightTime)).getRange()
								/ (airfield.fleet.get(idxLongestFlightTime)).getSpeed()) {
					idxLongestFlightTime = i;
				}
			}
			System.out.println("The plane with the longest flight time in the fleet is: "
					+ airfield.fleet.get(idxLongestFlightTime));
			return true;
		}
		case 6: {
			for (int i = 0; i < airfield.fleet.size(); i++) {
				if ((airfield.fleet.get(i)) instanceof CargoCarrier) {
					CargoPlane plane = (CargoPlane) airfield.fleet.get(i);
					plane.loadCargo();
				}
			}
			return true;
		}
		case 7: {
			for (int i = 0; i < airfield.fleet.size(); i++) {
				if ((airfield.fleet.get(i)) instanceof CombatReady) {
					FighterJet plane = (FighterJet) airfield.fleet.get(i);
					plane.fight();
				}
			}
			return true;
		}
		case 8: {
			System.out.println(
					"Enter the plane you would like to add.\n1 for Fighter Jet, 2 for Cargo Plane, 3 for Electronic Warfare Plane");
			int airplaneType = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter the Model of the Plane: ");
			String modelToAdd = sc.nextLine();
			System.out.print("Enter the Speed of the Plane: ");
			double speedToAdd = sc.nextDouble();
			sc.nextLine();
			System.out.print("Enter the Range of the Plane: ");
			int rangeToAdd = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter the Price of the Plane: ");
			long priceToAdd = sc.nextLong();
			sc.nextLine();
			switch (airplaneType) {
			case 1: {
				airfield.fleet.add(new FighterJet(modelToAdd, speedToAdd, rangeToAdd, priceToAdd));
				break;
			}
			case 2: {
				airfield.fleet.add(new CargoPlane(modelToAdd, speedToAdd, rangeToAdd, priceToAdd));
				break;
			}
			case 3: {
				airfield.fleet.add(new ElectronicWarfarePlane(modelToAdd, speedToAdd, rangeToAdd, priceToAdd));
				break;
			}
			}
			return true;
		}
		case 9: {
			System.out.println(
					"Using the following list, please enter the number corresponding to the plane you would like to remove.");
			for (int i = 0; i < airfield.fleet.size(); i++) {
				System.out.println((i + 1) + ". " + airfield.fleet.get(i));
			}
			int planeToRemove = sc.nextInt();
			sc.nextLine();
			airfield.fleet.remove(planeToRemove - 1);
			return true;
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
