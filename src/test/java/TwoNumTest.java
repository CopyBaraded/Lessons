import org.testng.Assert;
import org.testng.annotations.Test;

public class TwoNumTest {
    TwoNumbers comparator = new TwoNumbers();

    @Test
    void testFirstNumberGreater() {
        String result = comparator.compare(5, 3);
        Assert.assertEquals(result, "5 больше 3");
    }

    @Test
    void testSecondNumberGreater() {
        String result = comparator.compare(2, 4);
        Assert.assertEquals(result, "2 меньше 4");
    }

    @Test
    void testNumbersEqual() {
        String result = comparator.compare(7, 7);
        Assert.assertEquals(result, "7 равно 7");
    }
}
