import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void testAddition() {
        Assert.assertEquals(5, calculator.add(2, 3));
        Assert.assertEquals(0, calculator.add(-2, 2));
        Assert.assertEquals(-5, calculator.add(-2, -3));
    }

    @Test
    void testMultiplication() {
        Assert.assertEquals(6, calculator.multiply(2, 3));
        Assert.assertEquals(-4, calculator.multiply(-2, 2));
        Assert.assertEquals(6, calculator.multiply(-2, -3));
    }

    @Test
    void testDivision() {
        Assert.assertEquals(2.0, calculator.divide(6, 3));
        Assert.assertThrows(ArithmeticException.class, () -> calculator.divide(6, 0));
    }
}
