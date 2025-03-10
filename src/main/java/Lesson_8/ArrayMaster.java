package Lesson_8;
/*
1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
При подаче массива другого размера необходимо бросить исключение MyArraySizeException.

2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение
MyArrayDataException с детализацией, в какой именно ячейке лежат
неверные данные.
 */

public class ArrayMaster {
    public static void createArray(String[][] array) {
        if (array.length != 4) {
            throw new MyArraySizeException("Ошибка: массив должен быть размером 4x4");
        }
        for (String[] row : array) {
            if (row.length != 4) {
                throw new MyArraySizeException("Ошибка: Массив должен быть размером 4x4");
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                String value = array[i][j];
                if (value == null || value.isEmpty()) {
                    System.out.printf("Ячейка [%d][%d]: пустое значение\n", i, j);
                } else {
                    System.out.printf("Ячейка [%d][%d]: '%s' - корректное значение\n", i, j, value);
                }
            }
        }
    }
}
