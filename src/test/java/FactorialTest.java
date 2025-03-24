import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialTest {
    @Test
    void testFactorialPositiveNumbers() {
        Assert.assertEquals(1, Factorial.factorial(0)); // Факториал 0
        Assert.assertEquals(1, Factorial.factorial(1)); // Факториал 1
        Assert.assertEquals(2, Factorial.factorial(2)); // Факториал 2
        Assert.assertEquals(6, Factorial.factorial(3)); // Факториал 3
        Assert.assertEquals(24, Factorial.factorial(4)); // Факториал 4
        Assert.assertEquals(120, Factorial.factorial(5)); // Факториал 5
    }

    @Test
    void testFactorialLargeNumber() {
        Assert.assertEquals(3628800, Factorial.factorial(10)); // Факториал 10
    }

    @Test
    void testFactorialNegativeNumber() {
        // Отрицательный факториал невозможно определить
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            Factorial.factorial(-5);
        });
    }
}
