import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {
    @Test
    void testFactorialPositiveNumbers() {
        assertEquals(1, Factorial.factorial(0)); // Факториал 0
        assertEquals(1, Factorial.factorial(1)); // Факториал 1
        assertEquals(2, Factorial.factorial(2)); // Факториал 2
        assertEquals(6, Factorial.factorial(3)); // Факториал 3
        assertEquals(24, Factorial.factorial(4)); // Факториал 4
        assertEquals(120, Factorial.factorial(5)); // Факториал 5
    }

    @Test
    void testFactorialLargeNumber() {
        assertEquals(3628800, Factorial.factorial(10)); // Факториал 10
    }

    @Test
    void testFactorialNegativeNumber() {
        // Отрицательный факториал невозможно определить
        assertThrows(IllegalArgumentException.class, () -> {
            Factorial.factorial(-5);
        });
    }
}
