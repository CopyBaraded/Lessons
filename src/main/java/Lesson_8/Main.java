package Lesson_8;
/*
В методе main() вызвать полученный метод, обработать возможные исключения
MyArraySizeException и MyArrayDataException и вывести результат расчета.

Напишите код для генерации и поимки ArrayIndexOutOfBoundsException.
 */

import static Lesson_8.ArrayMaster.checkArray;

public class Main {
    public static void main(String[] args) {

        String[][] array = {
                {"1", "6", "3", "5"},
                {"2", "0", "2", "6"},
                {"4", "6", "a", "7"},
                {"3", "7", "12", "4"}
        };
        try {
            System.out.println("Сумма чисел массива:  " + checkArray(array));
        }
        catch (MyArraySizeException | MyArrayDataException  e) {
            System.err.println(e.getMessage());
        }
        try {
            System.out.println("Элемент массива:  " + array[10][4]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Ошибка: выход за границы массива  " + e.getMessage() + "\n Программа отработала корректно");
        }
    }
}

