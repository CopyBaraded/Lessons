package Lesson_6;
/*
Площадь  S = a ⋅ b
Периметр P = 2 ∙ (a + b), где a и b — длины сторон прямоугольника
 */

public class Rectangle implements Calculate{
    private double a;
    private double b;
    private String colorBody;
    private String colorBorder;

    public Rectangle(double a, double b, String colorBody, String colorBorder){
        this.a = a;
        this.b = b;
        this.colorBody = colorBody;
        this.colorBorder = colorBorder;
    }

    @Override
    public double getArea() {
        return a * b;
    }

    @Override
    public double getPerimeter() {
        return 2 * (a + b);
    }

    @Override
    public String getColorBody() {
        return colorBody;
    }

    @Override
    public String getColorBorder() {
        return colorBorder;
    }

}
