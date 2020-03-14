package edu.uah.cs.cs321.braden;

/**
 *<h1>Environment Class</h1>
 * Creates an Environment object with parameters
 * for simulation to run off <br>
 *
 *@author Braden McGee
 * <br>Basic Usage:<br>
 * <p>
 * <code>
 * Environment environ = new Environment();<br>
 * environ.isPlentiful = false;<br>
 * environ.isDangerous = false;<br>
 * </code>
 */
public class Environment {
    public Boolean isPlentiful;
    public Boolean isDangerous;

    /**
     Constructor
     */
    public Environment() {
        this.isPlentiful = false;
        this.isDangerous = false;
    }

}