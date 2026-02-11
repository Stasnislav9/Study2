import org.testng.annotations.*;
import static org.testng.Assert.*;

public class TriangleAreaCalculatorTest {

    @Test
    public void testCalculateArea() {
        assertEquals(TriangleAreaCalculator.calculateArea(10, 5), 25.0, 0.0001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAreaWithZeroBase() {
        TriangleAreaCalculator.calculateArea(0, 5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAreaWithNegativeHeight() {
        TriangleAreaCalculator.calculateArea(10, -2);
    }
}