import org.junit.*;

import static org.junit.Assert.assertEquals;

public class TriangleAreaCalculatorTest {

    @Test
    public void testCalculateArea(){
        assertEquals(25.0, TriangleAreaCalculator.calculateArea(10,5),0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAreaWithZeroBase(){
        TriangleAreaCalculator.calculateArea(0,5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAreaWithZeroHeight(){
        TriangleAreaCalculator.calculateArea(5,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAreaWithNegativeBase() {
        TriangleAreaCalculator.calculateArea(-5, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAreaWithNegativeHeight() {
        TriangleAreaCalculator.calculateArea(5, -5);
    }
}
