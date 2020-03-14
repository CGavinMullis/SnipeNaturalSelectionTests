package edu.uah.cs.cs321.evan;

import edu.uah.cs.cs321.braden.Simulation;

import java.util.*;
/**
 *<h1>Main Menu Class</h1>
 * Shows a list of options to begin the program with <br>
 *
 *@author Evan Geiger
 * <br>Basic Usage:<br>
 * <p>
 * <code>
 * MainMenu m = new MainMenu();<br>
 * m.RunSimulation();<br>
 * m.ReadDeathReports();<br>
 * </code>
 */

class MainMenu {
	//Setting list of death reports
	public List<String> DeathReports = new ArrayList<String>();
	//Running the simulation and adding to the death report list
	public void RunSimulation(MainMenu m) {
		Simulation s = new Simulation();
		m.SetSimulationParameters(s);
		s.RunNewSimulation();
		m.DeathReports.add(s.SummarizeDeaths());
		}
	//Setting paramaters for the start of the simulation
	public void SetSimulationParameters(Simulation s) {
		int userChoice = 0;
		System.out.println("Please set Initial Conditions");
		System.out.println("1. Sparse Environment");
		System.out.println("2. Plentiful Environment");
		Scanner in = new Scanner(System.in);
		userChoice = in.nextInt();
		System.out.println("\n\n");
		//User selection
		if(userChoice==1) {
			userChoice = 0;
			s.env.isPlentiful = false;
		} else if (userChoice==2) {
			userChoice = 0;
			s.env.isPlentiful = true;
		}
		System.out.println("1. Safe Environment");
		System.out.println("2. Dangerous Environment");
		userChoice = in.nextInt();
		System.out.println("\n\n");
		//User Selection
		if(userChoice==1) {
			userChoice = 0;
			s.env.isDangerous = false;
		} else if (userChoice==2) {
			userChoice = 0;
			s.env.isDangerous = true;
		}
	}
	//Listing out the death reports
	public void ReadDeathReport(MainMenu m) {
		int userChoice = 0;
		System.out.println("Please type the index of the Death Report you wish to view.");
		for(int i=0;i<m.DeathReports.size();i++) {
		System.out.println(m.DeathReports.get(i) + "\n");
		}
		Scanner in = new Scanner(System.in);
		userChoice = in.nextInt();
		System.out.println("\n\n");

		System.out.println(m.DeathReports.get(userChoice) + "/n");
	}
	
	
}