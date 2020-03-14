package edu.uah.cs.cs321.ed;

/**
*<h1>Snipe Class</h1>
* Creates a snipe object. This object will represent the fictional 
* species of animal used in the simulation<br>
*
*@author Ed Brown
* <br>Basic Usage:<br>
*<p>
* <code>
* Snipe s = new Snipe();<br>
* s.beakIsLong =false;<br>
* s.bodyIsFat = false;<br>
* s.longDistanceFlier = false;<br>
* s.conservativeGenes = false;<br>
* s.age = 0;<br>
* s.isAlive = true;<br>
* s.energy = 2;<br>
* </code>
*/
public class Snipe {
	public Boolean beakIsLong;
	public Boolean bodyIsFat;
	public Boolean longDistanceFlier;
	public Boolean conservativeGenes;
	public int age;
	public Boolean isAlive;
	public int energy;
	
	/**
	Default class constructor
	*/
	public Snipe() {
		this.beakIsLong = false;
		this.bodyIsFat = false;
		this.longDistanceFlier = false;
		this.conservativeGenes = false;
		this.age = 0;
		this.isAlive = true;
		this.energy = 2;
	}
	
	/**
	Returns a snipe's chance to find food
	@return chance a float representing the chances of finding food
	*/
	public float GetFoodChance() {
		float chance = 0.50f; //snipes start with a 50% chance of finding food
		
		//factor in beak length
		if (beakIsLong) {
			chance += .1; //if beak is long, 10% more likely to find food
		}else {
			chance -= .1; //if beak is short, 10% less likely to find food
		}
		
		//factor in flight specialization
		if (longDistanceFlier) {
			chance += .2; //if long distance flier, 20% more likely to find food
		}else {
			chance -= .1; //if short distance flier, 10% less likely to find food
		}
		
		return chance;
	}
	
	/**
	Returns a snipe's chance to survive and encounter with a predator
	@return chance a float representing the chances of survival
	*/
	public float GetSurvivalChance() {
		float chance = 0.5f; //snipes start with a 50% chance of surviving an encounter
		
		//factor in beak length
		if (beakIsLong) {
			chance -= .05; //if beak is long, 5% less likely to survive
		}else {
			chance += .1; //if beak is short, 5% more likely to survive
		}
		
		//factor in body shape
		if (bodyIsFat) {
			chance -= .1; //if fat, 10% more likely to survive
		}else {
			chance += .1; //if thin, 10% more likely to survive
		}
		
		
		//factor in flight specialization
		if (longDistanceFlier) {
			chance += .2; //if long distance flier, 20% more likely to survive
		}else {
			chance -= .1; //if short distance flier, 10% less likely to survive
		}
		
		return chance;
	}
	
	/**
	Generate a new snipe based on mate
	@param mate Snipe object to mate with
	@return offspring Snipe object
	*/
	public Snipe GenerateOffspring(Snipe mate) {
		Snipe offspring = new Snipe(); //create new snipe object
		
		//determine beak size
		int a = (int)(Math.random() * 2); //give me a random 0 or 1 to determine parent to pass trait
		if (a==0) { //if a=0 select this snipe
			if(this.conservativeGenes) {
				//if snipe has conservative genes pass trait down
				offspring.beakIsLong = this.beakIsLong;
			} else {
				//if snipe does not have conservative genes determine trait
				int b = (int)(Math.random() * 4);
				if (b==0) {
					//25% chance to pass opposite trait
					offspring.beakIsLong = !this.beakIsLong;
				} else {
					//75% chance to pass trait down
					offspring.beakIsLong = this.beakIsLong;
				}
			}
		}else { //if not zero select other parent to pass trait
			if(mate.conservativeGenes) {
				//if snipe has conservative genes pass trait down
				offspring.beakIsLong = mate.beakIsLong;
			} else {
				//if snipe does not have conservative genes determine trait
				int b = (int)(Math.random() * 4);
				if (b==0) {
					//25% chance to pass opposite trait
					offspring.beakIsLong = !mate.beakIsLong;
				} else {
					//75% chance to pass trait down
					offspring.beakIsLong = mate.beakIsLong;
				}
			}
		}
		
		//determine body type
		int c = (int)(Math.random() * 2); //give me a random 0 or 1 to determine parent to pass trait
		if (c==0) { //if c=0 select this snipe
			if(this.conservativeGenes) {
				//if snipe has conservative genes pass trait down
				offspring.bodyIsFat = this.bodyIsFat;
			} else {
				//if snipe does not have conservative genes determine trait
				int b = (int)(Math.random() * 4);
				if (b==0) {
					//25% chance to pass opposite trait
					offspring.bodyIsFat = !this.bodyIsFat;
				} else {
					//75% chance to pass trait down
					offspring.bodyIsFat = this.bodyIsFat;
				}
			}
		}else { //if not zero select other parent to pass trait
			if(mate.conservativeGenes) {
				//if snipe has conservative genes pass trait down
				offspring.bodyIsFat = mate.bodyIsFat;
			} else {
				//if snipe does not have conservative genes determine trait
				int b = (int)(Math.random() * 4);
				if (b==0) {
					//25% chance to pass opposite trait
					offspring.bodyIsFat = !mate.bodyIsFat;
				} else {
					//75% chance to pass trait down
					offspring.bodyIsFat = mate.bodyIsFat;
				}
			}
		}
		
		//determine flight specialization
		int d = (int)(Math.random() * 2); //give me a random 0 or 1 to determine parent to pass trait
		if (d==0) { //if a=0 select this snipe
			if(this.conservativeGenes) {
				//if snipe has conservative genes pass trait down
				offspring.longDistanceFlier = this.longDistanceFlier;
			} else {
				//if snipe does not have conservative genes determine trait
				int b = (int)(Math.random() * 4);
				if (b==0) {
					//25% chance to pass opposite trait
					offspring.longDistanceFlier = !this.longDistanceFlier;
				} else {
					//75% chance to pass trait down
					offspring.longDistanceFlier = this.longDistanceFlier;
				}
			}
		}else { //if not zero select other parent to pass trait
			if(mate.conservativeGenes) {
				//if snipe has conservative genes pass trait down
				offspring.longDistanceFlier = mate.longDistanceFlier;
			} else {
				//if snipe does not have conservative genes determine trait
				int b = (int)(Math.random() * 4);
				if (b==0) {
					//25% chance to pass opposite trait
					offspring.longDistanceFlier = !mate.longDistanceFlier;
				} else {
					//75% chance to pass trait down
					offspring.longDistanceFlier = mate.longDistanceFlier;
				}
			}
		}
		
		//determine genetic behavior
		int e = (int)(Math.random() * 2); //give me a random 0 or 1 to determine parent to pass trait
		if (e==0) { //if a=0 select this snipe
			if(this.conservativeGenes) {
				//if snipe has conservative genes pass trait down
				offspring.conservativeGenes = this.conservativeGenes;
			} else {
				//if snipe does not have conservative genes determine trait
				int b = (int)(Math.random() * 4);
				if (b==0) {
					//25% chance to pass opposite trait
					offspring.conservativeGenes = !this.conservativeGenes;
				} else {
					//75% chance to pass trait down
					offspring.conservativeGenes = this.conservativeGenes;
				}
			}
		}else { //if not zero select other parent to pass trait
			if(mate.conservativeGenes) {
				//if snipe has conservative genes pass trait down
				offspring.conservativeGenes = mate.conservativeGenes;
			} else {
				//if snipe does not have conservative genes determine trait
				int b = (int)(Math.random() * 4);
				if (b==0) {
					//25% chance to pass opposite trait
					offspring.conservativeGenes = !mate.conservativeGenes;
				} else {
					//75% chance to pass trait down
					offspring.conservativeGenes = mate.conservativeGenes;
				}
			}
		}
		
		//determine if egg made it from conception to birth
		int f = (int)(Math.random() * 2); //give me a random 0 or 1 to determine parent to pass trait
		if (f==0) {
			//egg hatches
			offspring.isAlive = true;
		} else {
			//egg did not hatch
			offspring.isAlive = false;
		}
		
		return offspring;
	}
	
	/**
	Determines the amount of energy lost at the end of the year.
	*/
	public void LoseEnergy() {
		if (bodyIsFat) {
			int a = (int)(Math.random() * 2); //give me a random 0 or 1
			if (a==1) {
				energy -= 1;
				return;
			}
		}else {
			int b = (int)(Math.random() * 4); //give me a random 0 to 3
			if (b==0) {
				energy -= 3;
				return;
			}
		}
		
		energy -= 2; //base energy needed
		return;
	}
	
}
