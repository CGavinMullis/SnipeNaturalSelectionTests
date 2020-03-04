import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Class for Environment Class
 *
 * @author Gavin Mullis
 */
class EnvironmentTest {
    Environment plentifulEnvironment;
    Environment dangerousEnvironment;


    /**
     * Before each test, create a plentiful Environment and a dangerous Environment.
     */
    @org.junit.jupiter.api.BeforeEach
    public void beforeEach() {
        plentifulEnvironment = new Environment(true);
        dangerousEnvironment = new Environment(false);
    }

    void plentifulTest()
    {
        assertTrue(plentifulEnvironment.isPlentiful());
        assertFalse(dangerousEnvironment.isPlentiful());
    }

    void dangerousTest()
    {
        assertFalse(plentifulEnvironment.isDangerous());
        assertTrue(dangerousEnvironment.isDangerous());
    }

    @org.junit.jupiter.api.Test
    void isPlentiful() {
        plentifulTest();
    }

    @org.junit.jupiter.api.Test
    void isDangerous() {
        dangerousTest();
    }
}