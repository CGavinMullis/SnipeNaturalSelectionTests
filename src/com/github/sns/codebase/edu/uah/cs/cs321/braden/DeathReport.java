package edu.uah.cs.cs321.braden;

/**
 *<h1>DeathReport Class</h1>
 * Creates a death report object detailing year, age, and
 * cause of death of a Snipe <br>
 *
 *@author Braden McGee
 * <br>Basic Usage:<br>
 * <p>
 * <code>
 * DeathReport reportSnipe1 = new DeathReport();<br>
 * reportSnipe1.year = 0;<br>
 * reportSnipe1.age = 0;<br>
 * reportSnipe1.cause = CauseOfDeath.Starvation;<br>
 * </code>
 */
public class DeathReport {
    enum CauseOfDeath {
        Starvation,
        Predation
    }
    public Integer year;
    public Integer age;
    public CauseOfDeath cause;

    /**
     Constructor
     */
    public DeathReport() {
        this.year = 0;
        this.age = 0;
        this.cause = CauseOfDeath.Starvation;
    }

}