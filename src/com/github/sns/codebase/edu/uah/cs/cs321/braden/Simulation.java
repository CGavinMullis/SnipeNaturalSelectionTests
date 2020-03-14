package edu.uah.cs.cs321.braden;

import edu.uah.cs.cs321.ed.Snipe;
import java.util.*;

/**
 *<h1>Simulation Class</h1>
 * Creates a simulation object to simulate evolution <br>
 *
 *@author Braden McGee
 * <br>Basic Usage:<br>
 * <p>
 * <code>
 * Simulation sim = new Simulation();<br>
 * sim.numYears = 10;<br>
 * sim.env.isPlentiful = true;<br>
 * sim.env.isDangerous = true;<br>
 * sim.RunNewSimulation();<br>
 * </code>
 */
public class Simulation {
    public Integer numYears;
    public Environment env;
    private List<DeathReport> deaths;
    private List<Snipe> snipes;

    /**
     * Constructor
     */
    public Simulation() {
        this.numYears = 0;
        this.env = new Environment();
        this.snipes = new ArrayList<>(600);
        this.deaths = new ArrayList<>();
    }

    /**
     * Runs the simulation for a certain number of years
     */
    public void RunNewSimulation() {
        int envBerries = 0;
        int envPredators = 0;

        // Clear list
        snipes.clear();
        // Filling list with 300 Snipes
        for(int i = 0; i < 300; i++) {
            Snipe snipe = new Snipe();

            // Generating random stats
            int c = (int)(Math.random() * 2); // gives 0 or 1
            if(c==0) {
                snipe.beakIsLong = false;
            }
            else snipe.beakIsLong = true;
            c = (int)(Math.random() * 2); // gives 0 or 1
            if(c==0) {
                snipe.bodyIsFat = false;
            }
            else snipe.bodyIsFat = true;
            c = (int)(Math.random() * 2); // gives 0 or 1
            if(c==0) {
                snipe.longDistanceFlier = false;
            }
            else snipe.longDistanceFlier = true;
            c = (int)(Math.random() * 2); // gives 0 or 1
            if(c==0) {
                snipe.conservativeGenes = false;
            }
            else snipe.conservativeGenes = true;

            // Adding snipe to list
            snipes.add(snipe);
        }

        // Simulation loop
        for (int i = 0; i < numYears; i++) {
            // Berry production (capped at 600)
            if (env.isPlentiful) envBerries += 400;
            else envBerries += 200;
            if(envBerries > 600) envBerries = 600;
            // Setting quantity of predators
            if(env.isDangerous) envPredators = 400;
            else envPredators = 200;

            // 1: Predator Encounters
            for(int j=0; j<envPredators; j++) {
                int c = (int)(Math.random() * 4); // gives 0-3
                if(c==3) {
                    if(snipes.isEmpty()) break; // Check if snipe list is empty
                    int snipeIndex = (int)(Math.random() * snipes.size()); // Allows a random index of the snipe list
                    Snipe predSnipe = snipes.get(c);
                    float chanceToSurvive = predSnipe.GetSurvivalChance();
                    float chanceToDie = (float)(Math.random()); // Random float
                    if(chanceToSurvive>=chanceToDie) predSnipe.energy -= 1; // Deduct energy by 1 if survive
                    // Make death report and remove snipe if dies
                    else {
                        predSnipe.isAlive = false;
                        DeathReport predDeath = new DeathReport();
                        predDeath.age = predSnipe.age;
                        predDeath.year = i;
                        predDeath.cause = DeathReport.CauseOfDeath.Predation;
                        deaths.add(predDeath);
                        snipes.remove(snipeIndex);
                    }
                }
            }

            // 2: Berry Encounters
            for (Snipe snipe : snipes) {
                if (envBerries == 0) break; // Check if no more berries
                Snipe berrySnipe = snipe;
                float noFoodChance = (float) (Math.random()); // Random float
                if (berrySnipe.GetFoodChance() >= noFoodChance) {
                    berrySnipe.energy += 4; // Increase energy by 4
                    envBerries -= 1;
                }
            }

            // 3: Yearly Energy Deduction
            for (Snipe yearSnipe : snipes) {
                yearSnipe.LoseEnergy();
            }

            // Death Checking for energy
            for(int j=0; j<snipes.size(); j++) {
                Snipe endSnipe = snipes.get(j);
                if(endSnipe.energy <= 0) {
                    endSnipe.isAlive = false;
                    DeathReport endDeath = new DeathReport();
                    endDeath.age = endSnipe.age;
                    endDeath.year = i;
                    endDeath.cause = DeathReport.CauseOfDeath.Starvation;
                    deaths.add(endDeath);
                    snipes.remove(j);
                    j -= 1; // Deducting j by 1 to compensate for removed snipe
                }
            }

            // Mating snipes

            // Making list to content baby snipes
            List<Snipe> babyList = new ArrayList<>((int)(snipes.size()/2));

            for(int j=0; j<((int)(snipes.size()/2)); j++){
                Snipe mateSnipe = snipes.get(j);
                Snipe babySnipe = mateSnipe.GenerateOffspring(snipes.get(j+1));
                babyList.add(babySnipe);
            }

            while(babyList.size()!=0){
                snipes.add(babyList.get(0));
                babyList.remove(0);
            }
        }
    }

    /**
     * Returns the number of snipes that died
     * @return Total number of deaths
     */
    public String SummarizeDeaths() {
        return "Total number of snipes that died: " + deaths.size();
    }

    public List<DeathReport> getDeaths() {
        return deaths;
    }
}