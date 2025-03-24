import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoNumTest {
    TwoNumbers comparator = new TwoNumbers();

    @Test
    void testFirstNumberGreater() {
        assertEquals("5 больше 3", comparator.compare(5, 3));
    }

    @Test
    void testSecondNumberGreater() {
        assertEquals("2 меньше 4", comparator.compare(2, 4));
    }

    @Test
    void testNumbersEqual() {
        assertEquals("7 равно 7", comparator.compare(7, 7));
    }
}
