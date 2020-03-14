import org.junit.jupiter.api.Test;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Class for Snipe Class
 * Assume parameterized only snipe creation
 *
 * @author Elizabeth Staley
 */
class SnipeTest {

    /**
     * Dummy Snipe Variables
     */
    //Unparameterized constructor
    //Snipe snipe1;
    //Snipe snipe2;

    //Lists for Parameterized Constructor
    ArrayList<Snipe> snipe1;
    ArrayList<Snipe> snipe2;

    /**
     * Possible Snipe Characteristics
     */
    boolean[] beakLengths;
    boolean[] bodyFats;
    boolean[] fliers;
    boolean[] genes;
    int[] ages;
    boolean[] aliveStatuses;
    int[] energies;

    /**
     * Function that runs before every test to initialize variables
     */
    @org.junit.jupiter.api.BeforeEach
    public void beforeEach()
    {
        //Unparameterized Constructor
        //snipe1 = new Snipe();
        //snipe2 = new Snipe();

        snipe1 = new ArrayList<>();
        snipe2 = new ArrayList<>();

        beakLengths = new boolean[]{true, false};
        bodyFats = new boolean[]{true, false};
        fliers = new boolean[]{true, false};
        genes = new boolean[]{true, false};

        for(Boolean length: beakLengths)
            for(Boolean fat: bodyFats)
                for(Boolean dist: fliers)
                    for(Boolean gene: genes)
                    {
                        //Create all possible snipes
                        snipe1.add(new Snipe(length, fat, dist, gene));
                        snipe2.add(new Snipe(length, fat, dist, gene));
                    }

        ages = IntStream.rangeClosed(1, 200).toArray(); //Simulation runs for 200 years, if never dies this is the max age
        aliveStatuses = new boolean[]{true, false};
        energies = IntStream.rangeClosed(0, 402).toArray(); //Max assumes 1 snozberry per year for 200 years (2*199 + 4), no predators
    }

    /**
     * Tests Getter/Setter for beakIsLong
     */
    void beakTest()
    {
        for(Boolean i : beakLengths)
        {
            //Unparameterized Creation
            //snipe1.setBeakIsLong(i);

            //Paramterized Creation
            //Create arbitrary Snipe to check functionality
            Snipe snipe = new Snipe(i, true, false, true);
            assertEquals(snipe.getBeakIsLong(),i);
        }
    }

    /**
     * Tests Getter/Setter for bodyIsFat
     */
    void fatTest()
    {
        for(Boolean i : bodyFats)
        {
            //Unparameterized Creation
            //snipe1.setBodyIsFat(i);

            //Paramterized Creation
            //Create arbitrary Snipe to check functionality
            Snipe snipe = new Snipe(true, i, false, true);
            assertEquals(snipe.getBodyIsFat(),i);
        }
    }

    /**
     * Tests Getter/Setter for longDistanceFlier
     */
    void flierTest()
    {
        for(Boolean i : fliers)
        {
            //Unparameterized Creation
            //snipe1.setLongDistanceFlier(i);

            //Paramterized Creation
            //Create arbitrary Snipe to check functionality
            Snipe snipe = new Snipe(true, true, i, true);
            assertEquals(snipe.getLongDistanceFlier(),i);
        }
    }

    /**
     * Tests Getter/Setter for conservativeGenes
     */
    void geneTest()
    {
        for(Boolean i : genes)
        {
            //Unparameterized Creation
            //snipe1.setConservativeGenes(i);

            //Paramterized Creation
            //Create arbitrary Snipe to check functionality
            Snipe snipe = new Snipe(false, true, false, i);
            assertEquals(snipe.getConservativeGenes(),i);
        }
    }

    /**
     * Tests Getter/Setter for age
     */
    void ageTest()
    {
        //Take out snipe loop if using unparameterized constructor
        for(Snipe snipe: snipe1)
        {
            for(Integer i : ages)
            {
                snipe.setAge(i);
                assertEquals(snipe.getAge(),i);
            }
        }
    }

    /**
     * Tests Getter/Setter for isAlive
     */
    void aliveStatusTest()
    {
        for(Snipe snipe: snipe1)
        {
            for(Boolean i : aliveStatuses)
            {
                snipe.setAlive(i);
                assertEquals(snipe.getAlive(),i);
            }
        }
    }

    /**
     * Tests Getter/Setter for energy
     */
    void energyTest()
    {
        for(Snipe snipe: snipe1)
        {
            for(Integer i : energies)
            {
                snipe.setEnergy(i);
                assertEquals(snipe.getEnergy(),i);
            }
        }
    }

    /**
     * Test to see if food chance is a proportion
     */
    @org.junit.jupiter.api.Test
    void getFoodChance()
    {
        //Assumption: should be between 0 and 1 (probability)
            //0.5 = base
            //-0.1 = short beak
            //+0.1 = long beak
            //-0.1 = short dist
            //+0.2 = long dist
        for(Snipe snipe: snipe1)
        {
            float num = snipe.GetFoodChance();
            boolean probFlag = ( (num >= 0) && (num <= 1) );
            assertTrue(probFlag);
        }
    }

    /**
     * Test to see if survival chance is a proportion
     */
    @org.junit.jupiter.api.Test
    void getSurvivalChance()
    {
        //Assumption: should be between 0 and 1 (probability)
            //Predators
                //0.5 = base
                //+0.5 = short beak
                //-0.5 = long beak
                //-0.1 = fat
                //+0.1 = thin
            //Needed energy
                //Base = 2 needed (0.5, 0.75)
                //Fat = 1 needed (0.5)
                //Thin = 3 needed (0.25)
        for(Snipe snipe: snipe1)
        {
            float num = snipe.GetSurvivalChance();
            boolean probFlag = ( (num >= 0) && (num <= 1) );
            assertTrue(probFlag);
        }
    }

    /**
     * Test to see if snipe generated correctly
     */
    @org.junit.jupiter.api.Test
    void generateOffspring()
    {
        //All possible snipe combinations
        for(Snipe mom: snipe1)
            for(Snipe dad: snipe2)
            {
                Snipe babySnipe = mom.GenerateOffspring(dad);
                //If both conservative
                if(mom.getConservativeGenes() && dad.getConservativeGenes())
                {
                    //Check to see if the traits are one of the parents'
                    //This test will cover two identical snipes making an exact copy

                    //Conditionals for assert statements
                    boolean fatTrait = ((babySnipe.getBodyIsFat() == mom.getBodyIsFat()) || (babySnipe.getBodyIsFat() == dad.getBodyIsFat()));
                    boolean distTrait = (babySnipe.getLongDistanceFlier() == mom.getLongDistanceFlier()) || (babySnipe.getLongDistanceFlier() == dad.getLongDistanceFlier());
                    boolean beakTrait = (babySnipe.getBeakIsLong() == mom.getBeakIsLong()) || (babySnipe.getBeakIsLong() == dad.getBeakIsLong());

                    assertTrue(babySnipe.getConservativeGenes());
                    assertTrue(fatTrait);
                    assertTrue(distTrait);
                    assertTrue(beakTrait);
                }
                //Otherwise: cannot guarantee traits, check that snipe has a value for the trait
                else
                {
                    //Conditionals for assert statements
                    boolean geneTrait = (babySnipe.getConservativeGenes()) || (!babySnipe.getConservativeGenes());
                    boolean fatTrait = (babySnipe.getBodyIsFat()) || (!babySnipe.getBodyIsFat());
                    boolean distTrait = (babySnipe.getLongDistanceFlier()) || (!babySnipe.getLongDistanceFlier());
                    boolean beakTrait = (babySnipe.getBeakIsLong()) || (!babySnipe.getBeakIsLong());

                    assertTrue(geneTrait);
                    assertTrue(fatTrait);
                    assertTrue(distTrait);
                    assertTrue(beakTrait);
                }

                //Check that it has 2 units of energy if it makes it to birth
                if(babySnipe.getAlive())
                {
                    assertEquals(babySnipe.getEnergy(), 2);
                }
            }
    }

    /**
     * Test to see if snipe energy changes at the end of the year
     */
    @org.junit.jupiter.api.Test
    void loseEnergy()
    {
        //Assumption from specifications: loseEnergy is actually the changeEnergy function
        // Will test to see if energy changed rather than strictly decreased

        //All possible snipe combinations
        for(Snipe snipe: snipe1)
        {
            for(int energy: energies)
            {
                snipe.setEnergy(energy);
                //Call function to make sure it works
                snipe.LoseEnergy(/*Place parameters here*/);
                //If snipe lived, check to see if energy has changed
                //Assumption: Energy cannot stay the same
                     //+4 = Snozberry found during first year, no predator
                     //+2 = Snozberry found any other year, no predator
                     //-2 = No Snozberry found, no predator
                     //-1 more for all cases that a snipe gets attacked by one predator

                if(snipe.getAlive())
                {
                    //make sure energy changed

                    boolean flag = snipe.getEnergy() == energy;
                    assertFalse(flag);
                }

                //Assumption: Should not test if dead snipe has energy of zero or less because can be killed with energy of 5
                // Can test that snipe with energy of zero or less must be dead
                if(snipe.getEnergy() <= 0)
                {
                    assertFalse(snipe.getAlive());
                }
            }
        }
    }

    /**
     * Runs of tests for getters/setters
     * Setter test for snipe characteristics included but commented out for parameterized constructor only case
     */
    @org.junit.jupiter.api.Test
    void getBeakIsLong() { beakTest(); }
    /*
    @org.junit.jupiter.api.Test
    void setBeakIsLong() { beakTest(); }
    */
    @org.junit.jupiter.api.Test
    void getBodyIsFat() { fatTest(); }
    /*
    @org.junit.jupiter.api.Test
    void setBodyIsFat() { fatTest(); }
    */
    @org.junit.jupiter.api.Test
    void getLongDistanceFlier() { flierTest(); }
    /*
    @org.junit.jupiter.api.Test
    void setLongDistanceFlier() { flierTest(); }
    */
    @org.junit.jupiter.api.Test
    void getConservativeGenes() { geneTest(); }
    /*
    @org.junit.jupiter.api.Test
    void setConservativeGenes() { geneTest(); }
    */
    @org.junit.jupiter.api.Test
    void getAge() { ageTest(); }

    @org.junit.jupiter.api.Test
    void setAge() { ageTest(); }

    @org.junit.jupiter.api.Test
    void getAlive() { aliveStatusTest(); }

    @org.junit.jupiter.api.Test
    void setAlive() { aliveStatusTest(); }

    @org.junit.jupiter.api.Test
    void getEnergy() { energyTest(); }

    @org.junit.jupiter.api.Test
    void setEnergy() { energyTest(); }
}