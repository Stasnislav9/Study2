import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberComparatorTest {

    @Test
    public void testCompareGreater(){
        assertEquals("5 > 3", NumberComparator.compare(5,3));
    }
    @Test
    public void testCompareLess(){
        assertEquals("3 < 5", NumberComparator.compare(3,5));
    }
    @Test
    public void testCompareEqual(){
        assertEquals("5 = 5", NumberComparator.compare(5,5));
    }
}
