import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число для вычисления факториала: ");

        try {
            int number = scanner.nextInt();
            if (number < 0) {
                System.out.println("Факториал определен только для неотрицательных чисел.");
            } else {
                System.out.println("Факториал числа " + number + " равен " + Factorial.factorial(number));
            }
        } catch (Exception e) {
            System.out.println("Пожалуйста, введите целое число.");
        }

        System.out.println("Введите длины сторон треугольника:");
        try {
            System.out.print("Сторона a: ");
            double a = scanner.nextDouble();
            System.out.print("Сторона b: ");
            double b = scanner.nextDouble();
            System.out.print("Сторона c: ");
            double c = scanner.nextDouble();

            // Проверка существования треугольника
            if (a + b > c && a + c > b && b + c > a) {
                double area = TriangleArea.calculateArea(a, b, c);
                System.out.printf("Площадь треугольника: %.2f\n", area);
            } else {
                System.out.println("Треугольник с такими сторонами не существует.");
            }
        } catch (Exception e) {
            System.out.println("Пожалуйста, введите корректные числовые значения.");
        }

        Calculator calculator = new Calculator();

        System.out.print("Введите первое число: ");
        int num1 = scanner.nextInt();

        System.out.print("Введите второе число: ");
        int num2 = scanner.nextInt();

        System.out.println("Выберите операцию:");
        System.out.println("1 - Сложение");
        System.out.println("2 - Вычитание");
        System.out.println("3 - Умножение");
        System.out.println("4 - Деление");

        int choice = scanner.nextInt();

        try {
            switch (choice) {
                case 1:
                    System.out.println("Результат сложения: " + calculator.add(num1, num2));
                    break;
                case 2:
                    System.out.println("Результат вычитания: " + calculator.subtract(num1, num2));
                    break;
                case 3:
                    System.out.println("Результат умножения: " + calculator.multiply(num1, num2));
                    break;
                case 4:
                    System.out.println("Результат деления: " + calculator.divide(num1, num2));
                    break;
                default:
                    System.out.println("Неверный выбор операции.");
            }
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        TwoNumbers comparator = new TwoNumbers();

        System.out.print("Введите первое число: ");
        int num_1 = scanner.nextInt();

        System.out.print("Введите второе число: ");
        int num_2 = scanner.nextInt();

        System.out.println(comparator.compare(num_1, num_2));
    }

}
