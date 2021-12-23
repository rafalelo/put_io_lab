package put.io.testing.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calc;

    @BeforeEach
    void setup() {
        calc = new Calculator();
    }

    @Test
    void add() {
        assertEquals(20, calc.add(10, 10));
    }

    @Test
    void multiply() {
        assertEquals(20, calc.multiply(4, 5));
    }
}