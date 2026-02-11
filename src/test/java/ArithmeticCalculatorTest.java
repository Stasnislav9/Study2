import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArithmeticCalculatorTest {

    @Test
    public void testAdd (){
        assertEquals(5, ArithmeticCalculator.add(2,3));
    }
    @Test
    public void testSubtract(){
        assertEquals(5, ArithmeticCalculator.subtract(5,0));
    }
    @Test
    public void testMyltiply(){
        assertEquals(6, ArithmeticCalculator.myltiply(2,3));
    }
    @Test
    public void testDivide(){
        assertEquals(10, ArithmeticCalculator.divide(100,10),0.001);
    }
    @Test(expected = ArithmeticException.class)
    public void testDivideByZero(){
        ArithmeticCalculator.divide(5,0);
    }



}
