package put.io.testing.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FailureOrErrorTest {

    Calculator calc;

    @BeforeEach
    void setup() {
        calc = new Calculator();
    }

    @Test
    void test1() {
        // Ten test jest oznaczany jako failure
        assertEquals(20, 10);
    }

    @Test
    void test2() {
        // Ten test jest oznaczany jako error
        throw new IllegalArgumentException("The arguments must be positive");
    }

    @Test
    void test3() {
        try {
            assertEquals(1, 2);
        } catch (Throwable err) { // Chodzi o Throwable
            err.printStackTrace();
        }
    }
}