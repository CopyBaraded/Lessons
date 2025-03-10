package Lesson_8;

import static Lesson_8.ArrayMaster.checkArray;

public class Main {
    public static void main(String[] args) {
        try {
//            String[][] array1 = {
//                    {"1", "a", "3", "7"},
//                    {"", "b", "2", "6"},
//                    {"4", "6", "4", "7"},
//                    {"3", "", "12", "4"}
//            };
            String[][] array2 = {
                    {"1", "2", "три", "4"},
                    {"5", "6", "7", "8"},
                    {"9", "10", "11", "12"},
                    {"13", "14", "15", "16"}
            };
//            String[][] array3 = {
//                    {"1", "2", "3", "4"},
//                    {"5", "6", "7", "8"},
//                    {"9", "10", "11", "12"},
//                    {"13", "14", "15", "16"}
//            };
//            System.out.println("sum  " + checkArray(array1));
//
            System.out.println("sum  " + checkArray(array2));
//
//            System.out.println("sum  " + checkArray(array3));
        }
        catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }

    }
}

