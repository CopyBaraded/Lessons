package catDog.example;

import java.util.Random;


public class Main {
    public static void main(String[] args) {
        Dog dogShar = new Dog();
        dogShar.jamp(" Шарик ", 5);

        Cats catBarsik = new Cats();
        catBarsik.swim(" Барсик ", 4);

        Bowl bowl = new Bowl(50);

        Cats[] cats = {
                new Cats("Murzik"),
                new Cats("Garry"),
                new Cats("Funtik"),
                new Cats("Pupsik"),
                new Cats("Puffnutiy"),
                new Cats("Garfield")
        };
        Random random = new Random();
        int appetite = random.nextInt(100);
        System.out.println("АППЕТИТ у котиков:  " + appetite);
        for (Cats cat : cats) {
            cat.eat(bowl, appetite);
        }

        System.out.println("Информация о сытости котов:");
        for (Cats cat : cats) {
            System.out.println(cat.name + " сыт: " + cat.doneHunger());
        }

        System.out.println("Осталось еды в миске: " + bowl.getFood());

        bowl.addFood(30);
        System.out.println("Добавили еды в миску. Теперь в миске: " + bowl.getFood());


        System.out.println("Создано животных: " + Animal.getCountAnimals());
        System.out.println("Создано котиков: " + Cats.getCountCats());
        System.out.println("Создано сабачек: " + Dog.getCountDogs());

        Circle circle = new Circle(8, "черный", "красный");
        Rectangle rectangle = new Rectangle(6, 8, "желтый", "синий");
        Triangle triangle = new Triangle(5, 3, 4, "зеленый", "розовый");

        System.out.println("Круг посчитан: ");
        circle.printInfo();
        System.out.println("Прямоугольник посчитан: ");
        rectangle.printInfo();
        System.out.println("Треугольник посчитан: ");
        triangle.printInfo();
    }
}