package put.io.testing.audiobooks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {

    //Customer cust;
    Audiobook aud;
    AudiobookPriceCalculator apc;

    @BeforeEach
    void setup() {
        aud = new Audiobook("testAudiobook", 10);
        apc = new AudiobookPriceCalculator();
    }

    @Test
    void isSubscriber() {
        Customer cust = new Customer("John", Customer.LoyaltyLevel.GOLD, true);
        assertEquals(0.0, apc.calculate(cust, aud));
    }

    @Test
    void gold() {
        Customer cust = new Customer("John", Customer.LoyaltyLevel.GOLD, false);
        assertEquals(0.8*10, apc.calculate(cust, aud));
    }

    @Test
    void silver() {
        Customer cust = new Customer("John", Customer.LoyaltyLevel.SILVER, false);
        assertEquals(0.9*10, apc.calculate(cust, aud));
    }
    @Test
    void standard() {
        Customer cust = new Customer("John", Customer.LoyaltyLevel.STANDARD, false);
        assertEquals(10, apc.calculate(cust, aud));
    }
}