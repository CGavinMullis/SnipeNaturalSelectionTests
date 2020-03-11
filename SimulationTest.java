import java.util.stream.IntStream;

import edu.uah.cs.cs321.ed.Simulation;
import edu.uah.cs.cs321.ed.Environment;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Class for Simulation Class
 *
 * @author Brianna Bell
 */
class SimulationTest {
    Simulation testSim;             // simulation to test
    int[] numYears;                 // array of number of years the simulation will run
    Environment[] environments;     // array of different environments the simulation

    /**
     * Runs before each test to reset variables
     */
    @org.junit.jupiter.api.BeforeEach
    public void beforeEach() {
        testSim = new Simulation();             // initialize new simulation
        numYears = new int[]{200,400,600,800};  // set increments of years to run the simulation
        // will update environments according to code to test
       // environments = new Environment[]{safe&plentiful,unsafe&plentiful,safe&notPlentiful,unsafe&notPlentiful}  // set different environments
        environments[0] = new Environment();
        environments[0].isPlentiful = true;
        environments[0].isDangerous = true;

        environments[1] = new Environment();
        environments[1].isPlentiful = true;
        environments[1].isDangerous = false;

        environments[2] = new Environment();
        environments[2].isPlentiful = false;
        environments[2].isDangerous = true;

        environments[3] = new Environment();
    }

    /**
     * Tests that simulation runs without exception
     */
    @org.junit.jupiter.api.Test
    void testRunSimulation() {
        testSim.RunNewSimulation();
        assert true;
    }

    /**
     * Tests that SummarizeDeaths function returns a string with something in it
     */
    @org.junit.jupiter.api.Test
    void testSummarizeDeaths() {
        testSim.RunNewSimulation();                 // run simulation so that there are deaths to summarize
        String deaths = testSim.SummarizeDeaths();  // summarize deaths
        if(deaths == null || deaths.isEmpty())      // check if the string is null or empty
            assert false;
        else
            assert true;
    }

    /**
     * Test the setter and getter of numYears
     */
    void numYearsTest() {
        for(int i : numYears) {
            testSim.setNumYears(i);
            assertEquals(testSim.getNumYears(), i);
        }
    }

    /**
     * Test the setter and getter of Environments
     */
    void environmentTest() {
        for(Environment env : environments) {
            testSim.setEnvironment(env);
            assertEquals(testSim.getEnvironment(), env);
        }
    }

    /**
     * Tests that 300 snipes were created
     */
    void snipeCreationTest(){
        assertEquals(testSim.GetSnipes().size(), 300);
    }

    /**
     * Test that number of snipes has changed after the simulation runs
     */
    void snipeDeathTest(){
        testSim.RunNewSimulation();
        assertNotEquals(testSim.GetSnipes().size(), 300);
    }

    /**
     * Test that there are deaths in each starvation and predation categories
     */
    void deathReportTest(){
        testSim.RunNewSimulation();
        assertEquals(testSim.GetDeaths().size(), 2);
    }

    /**
     * Test numYears getter
     */
    @org.junit.jupiter.api.Test
    void getNumYears() {
        numYearsTest();
    }

    /**
     * Test numYears setter
     */
    @org.junit.jupiter.api.Test
    void setNumYears() {
        numYearsTest();
    }

    /**
     * Test environment getter
     */
    @org.junit.jupiter.api.Test
    void getEnvironment() {
        environmentTest();
    }

    /**
     * Test environment setter
     */
    @org.junit.jupiter.api.Test
    void setEnvironment() {
        environmentTest();
    }


}
