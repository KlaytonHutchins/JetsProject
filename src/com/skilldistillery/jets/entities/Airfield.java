package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Airfield {

	public List<Airplane> fleet;
	
	Scanner sc = new Scanner(System.in);
	
	public Airfield() {
		fleet = new ArrayList<>();
		addFromFile(fleet);
	}

	public void addFromFile(List<Airplane> fleet) {
		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {

				String[] params = line.split(", ");
				switch (params[0]) {
				case "FighterJet": {
					fleet.add(new FighterJet(params[1], Double.parseDouble(params[2]), Integer.parseInt(params[3]),
							Long.parseLong(params[4])));
					break;
				}
				case "CargoPlane": {
					fleet.add(new CargoPlane(params[1], Double.parseDouble(params[2]), Integer.parseInt(params[3]),
							Long.parseLong(params[4])));
					break;
				}
				case "ElectronicWarfarePlane": {
					fleet.add(new ElectronicWarfarePlane(params[1], Double.parseDouble(params[2]),
							Integer.parseInt(params[3]), Long.parseLong(params[4])));
					break;
				}
				}

			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public boolean listFleet() {
		for (Airplane ap : fleet) {
			System.out.println(ap);
		}
		return true;
	}

	public boolean flyAllPlanes() {
		for (Airplane ap : fleet) {
			ap.fly();
		}
		return true;
	}

	public boolean viewFastestPlane() {
		int idxFastestPlane = 0;
		for (int i = 0; i < fleet.size(); i++) {
			if ((fleet.get(i)).getSpeed() > (fleet.get(idxFastestPlane)).getSpeed()) {
				idxFastestPlane = i;
			}
		}
		System.out.println("The fastest plane in the fleet is: " + fleet.get(idxFastestPlane));
		return true;
	}

	public boolean viewPlaneLongestRange() {
		int idxLongestRangePlane = 0;
		for (int i = 0; i < fleet.size(); i++) {
			if ((fleet.get(i)).getRange() > (fleet.get(idxLongestRangePlane)).getRange()) {
				idxLongestRangePlane = i;
			}
		}
		System.out.println(
				"The plane with the longest range in the fleet is: " + fleet.get(idxLongestRangePlane));
		return true;
	}

	public boolean viewPlaneLongestFlightTime() {
		int idxLongestFlightTime = 0;
		for (int i = 0; i < fleet.size(); i++) {
			if ((fleet.get(i)).getRange()
					/ (fleet.get(i)).getSpeed() > (fleet.get(idxLongestFlightTime)).getRange()
							/ (fleet.get(idxLongestFlightTime)).getSpeed()) {
				idxLongestFlightTime = i;
			}
		}
		System.out.println("The plane with the longest flight time in the fleet is: "
				+ fleet.get(idxLongestFlightTime));
		return true;
	}

	public boolean loadAllCargoPlanes() {
		for (int i = 0; i < fleet.size(); i++) {
			if ((fleet.get(i)) instanceof CargoCarrier) {
				CargoPlane plane = (CargoPlane) fleet.get(i);
				plane.loadCargo();
			}
		}
		return true;
	}

	public boolean dogfight() {
		for (int i = 0; i < fleet.size(); i++) {
			if ((fleet.get(i)) instanceof CombatReady) {
				FighterJet plane = (FighterJet) fleet.get(i);
				plane.fight();
			}
		}
		return true;
	}

	public boolean addPlaneToFleet() {
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
			fleet.add(new FighterJet(modelToAdd, speedToAdd, rangeToAdd, priceToAdd));
			break;
		}
		case 2: {
			fleet.add(new CargoPlane(modelToAdd, speedToAdd, rangeToAdd, priceToAdd));
			break;
		}
		case 3: {
			fleet.add(new ElectronicWarfarePlane(modelToAdd, speedToAdd, rangeToAdd, priceToAdd));
			break;
		}
		}
		return true;
	}

	public boolean removePlaneFromFleet() {
		System.out.println(
				"Using the following list, please enter the number corresponding to the plane you would like to remove.");
		for (int i = 0; i < fleet.size(); i++) {
			System.out.println((i + 1) + ". " + fleet.get(i));
		}
		int planeToRemove = sc.nextInt();
		while (planeToRemove < 1 || planeToRemove > fleet.size()) {
			System.err.print("Invalid entry, please choose a number from 1 - " + fleet.size() + ": ");
			planeToRemove = sc.nextInt();
		}
		sc.nextLine();
		fleet.remove(planeToRemove - 1);
		return true;
	}

}
