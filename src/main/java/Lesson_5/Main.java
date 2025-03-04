package Lesson_5;
/*
Task 4 Создать массив из 5 товаров.
Пример:
вначале объявляем массив объектов
Product[] productsArray = new Product[5];
потом для каждой ячейки массива задаем объект
productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
"Samsung Corp.", "Korea", 5599, true);
productsArray[1] = new Product(...);
productsArray[4] = new Product(...);
 */



public class Main {
    public static void main(String[] args) {
//        Product[] productsArray = new Product[5];
//
//        productsArray[0] = new Product("Sums S25 U", "Sum corp.", "Korea", "13.01.2025", 2500, false);
//        productsArray[1] = new Product("Google Pixel 6", "Hon Hai Precision Industry Co.", "Taiwan", "15.03.2020", 1100, true);
//        productsArray[2] = new Product("Google Pixel 7", "Hon Hai Precision Industry Co.", "Taiwan", "25.12.2022", 2100, true);
//        productsArray[3] = new Product("Google Pixel 8", "Hon Hai Precision Industry Co.", "Taiwan", "03.09.2024", 2100, true);
//        productsArray[4] = new Product("Nokia 3310", "Human Mobile Devices", "Finland", "26.02.2017", 100, false);
//
//
//        productsArray[2].productInfo();
        Park imGorkogo = new Park("им. М.Горького");

        Park.SaveInfoPark haliGali = imGorkogo.new SaveInfoPark("Хали-Гали ", "с 8:00 до 21.00 ", 13);
        haliGali.parkInfo();

    }
}