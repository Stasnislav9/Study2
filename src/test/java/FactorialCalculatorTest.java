import org.testng.annotations.*;
import static org.testng.Assert.*;

public class FactorialCalculatorTest {

    @Test
    public void testFactorialZero() {
        assertEquals(FactorialCalculator.calculateFactorial(0), 1);
    }

    @Test
    public void testFactorialFive() {
        assertEquals(FactorialCalculator.calculateFactorial(5), 120);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative() {
        FactorialCalculator.calculateFactorial(-5);
    }
}