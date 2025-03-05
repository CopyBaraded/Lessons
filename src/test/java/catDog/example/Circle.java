package catDog.example;
/*
Площадь круга определяется по формуле S = π ⋅ r ⋅ r
Формула расчета периметра круга:      C = 2 · π · r где r – радиус, π – число пи.
 */

public class Circle implements Calculate {
    private double radius;
    private String colorBody;
    private String colorBorder;

    public Circle(double radius, String colorBody, String colorBorder){
        this.radius = radius;
        this.colorBody = colorBody;
        this.colorBorder = colorBorder;
    }


    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
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
