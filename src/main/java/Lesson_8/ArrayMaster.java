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

import java.util.Arrays;

public class ArrayMaster {
    public static int checkArray(String[][] array) {
        if (array.length != 4) {
            throw new MyArraySizeException("Ошибка: массив должен быть размером 4x4");
        }
        for (String[] row : array) {
            if (row.length != 4) {
                throw new MyArraySizeException("Ошибка: Массив должен быть размером 4x4");
            }
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                }
                catch (NumberFormatException e){
                    throw new MyArrayDataException("Ошибка данных в ячейке" + i, j, array[i][j]);
                }
            }
        }
        return sum;
    }
}
