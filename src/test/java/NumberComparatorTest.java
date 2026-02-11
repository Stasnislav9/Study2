import org.testng.annotations.*;
import static org.testng.Assert.*;

public class NumberComparatorTest {

    @Test
    public void testCompareGreater() {
        assertEquals(NumberComparator.compare(5, 3), "5 > 3");
    }

    @Test
    public void testCompareLess() {
        assertEquals(NumberComparator.compare(3, 5), "3 < 5");
    }

    @Test
    public void testCompareEqual() {
        assertEquals(NumberComparator.compare(7, 7), "7 = 7");
    }
}