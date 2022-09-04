package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.entities.Airfield;
import com.skilldistillery.jets.entities.Airplane;

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
		displayUserMenu();
		int userSelection = sc.nextInt();
		while (userSelection < 1 || userSelection > 9) {
			userSelection = sc.nextInt();
		}
		implementUserSelection(userSelection);

	}

	public void displayUserMenu() {
		System.out.println("1. List fleet\n2. Fly all planes\n3. View fastest plane\n4. View plane with longest range"
				+ "\n5. Load all cargo planes\n6. Dogfight!\n7. Add a plane to Fleet\n8. Remove a plane from Fleet\n9. Quit");
	}

	public void implementUserSelection(int menuNum) {
		switch (menuNum) {
		case 1: {
			for (Airplane ap : airfield.fleet) {
				System.out.println(ap);;
			}
		}
		case 2:{
			for (Airplane ap : airfield.fleet) {
				ap.fly();
			}
		}
		case 3: {
			int idxFastestPlane = 0;
			for (int i = 0; i < airfield.fleet.size(); i++) {
				if ((airfield.fleet.get(i)).getSpeed() > (airfield.fleet.get(idxFastestPlane)).getSpeed()) {
					idxFastestPlane = i;
				}
			}
			System.out.println(airfield.fleet.get(idxFastestPlane));
		}

		case 4:

		case 5:

		case 6:

		case 7:

		case 8:

		case 9:

		}
	}

}
