import org.junit.*;

import static org.junit.Assert.assertEquals;

public class FactorialCalculatorTest {

    @Test
    public void testFactorailZero(){
        assertEquals (1, FactorialCalculator.calculateFactorial(0));
    }

    @Test
    public void testFactorialOne(){
        assertEquals(1, FactorialCalculator.calculateFactorial(1));
    }

    @Test
    public void testFactorial(){
        assertEquals(6,FactorialCalculator.calculateFactorial(3) );
    }

}
