package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Airfield {

	public List<Airplane> fleet;

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

}
