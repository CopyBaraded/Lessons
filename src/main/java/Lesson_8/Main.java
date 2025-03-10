package Lesson_8;

import static Lesson_8.ArrayMaster.checkArray;

public class Main {
    public static void main(String[] args) {
        try {
            String[][] array = {
                    {"1", "6", "3", "5"},
                    {"2", "0", "2", "6"},
                    {"4", "6", "4", "7"},
                    {"3", "7", "12", "4"}
            };

            System.out.println("sum  " + checkArray(array));

        }
        catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }

    }
}

