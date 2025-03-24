import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {
    TriangleArea triangleArea = new TriangleArea();

    @Test
    void testValidTriangle() {
        assertEquals(6.0, triangleArea.calculateArea(3, 4, 5), 0.1); // Проверка правильного треугольника
    }

    @Test
    void testInvalidTriangle() {
        assertThrows(IllegalArgumentException.class, () -> triangleArea.calculateArea(1, 2, 10)); // Треугольник не существует
    }

    @Test
    void testNullTriangle(){
        assertThrows(IllegalArgumentException.class, () -> triangleArea.calculateArea(0, 0, 0));  // Нулевые стороны
    }

    @Test
    void testNegativeSides() {
        assertThrows(IllegalArgumentException.class, () -> triangleArea.calculateArea(-3, 4, 5)); // Отрицательная сторона
        assertThrows(IllegalArgumentException.class, () -> triangleArea.calculateArea(3, -4, 5));
    }

    @Test
    void testEdgeCaseTriangle() {
        assertEquals(0.0, triangleArea.calculateArea(1, 1, 2), 0.001); // Треугольник с нулевой площадью
    }
}
