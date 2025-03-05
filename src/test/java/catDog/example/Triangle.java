package catDog.example;
/*
Площадь  S = √p · (p — a)(p — b)(p — c), где a, b и c это стороны треугольника и p – половина периметра треугольника.
Периметр P = a + b + c , где a, b, и c — стороны треугольника
 */

public class Triangle implements Calculate {
    private double a;
    private double b;
    private double c;
    private String colorBody;
    private String colorBorder;

    public Triangle(double a, double b, double c, String colorBody, String colorBorder){
        this.a = a;
        this.b = b;
        this.c = c;
        this.colorBody = colorBody;
        this.colorBorder = colorBorder;
    }
    @Override
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
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
