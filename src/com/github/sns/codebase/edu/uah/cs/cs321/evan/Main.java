package edu.uah.cs.cs321.evan;

import edu.uah.cs.cs321.evan.MainMenu;

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Boolean MenuFlag = true;
		MainMenu m = new MainMenu();
		// Menu Selection
		while (MenuFlag) {
			int userChoice = 0;
			System.out.println("Welcome to Snipe Simulation v0.1. Please select an option:");
			System.out.println("1. Run New Simulation");
			System.out.println("2. View Death Reports");
			System.out.println("3. Quit program");
			Scanner in = new Scanner(System.in);
			userChoice = in.nextInt();
			System.out.println("\n\n");
			//Results based on user selection
			if(userChoice==1) {
				userChoice = 0;
				m.RunSimulation(m);
			}
			else if(userChoice==2) {
				userChoice = 0;
				m.ReadDeathReport(m);
			}
			else if(userChoice==3) {
				MenuFlag=false;
			}
	
		}
	}
}
