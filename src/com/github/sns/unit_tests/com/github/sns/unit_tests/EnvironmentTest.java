package com.github.sns.unit_tests;

import edu.uah.cs.cs321.braden.Environment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Class for com.github.sns.unit_tests.Environment Class
 *
 * @author Gavin Mullis
 */
class EnvironmentTest {
    Environment environment;

    /**
     * Before each test, create an com.github.sns.unit_tests.Environment
     */
    @org.junit.jupiter.api.BeforeEach
    public void beforeEach() {
        environment = new Environment();
    }

    /**
     * Tests getters and setters for isPlentiful Variable
     */
    void plentifulTest()
    {
        //environment.setPlentiful(false);
        //assertFalse(environment.getPlentiful());

        //environment.setPlentiful(true);
        //assertTrue(environment.getPlentiful());
    }

    /**
     * Tests getters and setters for isDangerous Variable
     */
    void dangerousTest()
    {
        //environment.setDangerous(false);
        //assertFalse(environment.getDangerous());

        //environment.setDangerous(true);
        //assertTrue(environment.getDangerous());
    }

    @org.junit.jupiter.api.Test
    void setPlentiful() {
        plentifulTest();
    }

    @org.junit.jupiter.api.Test
    void setDangerous() {
        dangerousTest();
    }

    @org.junit.jupiter.api.Test
    void getPlentiful() {
        plentifulTest();
    }

    @org.junit.jupiter.api.Test
    void getDangerous() {
        dangerousTest();
    }
}