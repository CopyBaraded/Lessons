package Lesson_9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Poly ", "gr. 1", 1, new LinkedList<>(List.of(3, 3, 5, 4))));
        students.add(new Student("Moly ", "gr. 2", 1, new LinkedList<>(List.of(3, 3, 5, 4))));
        students.add(new Student("Jeny ", "gr. 3", 1, new LinkedList<>(List.of(3, 3, 2, 4, 2, 2))));
        students.add(new Student("Bobi ", "gr. 4", 1, new LinkedList<>(List.of(3, 3, 2, 3))));

        students.removeIf(student -> student.averageGrade() < 3.0);

        for (Student student : students)
            student.transferToCourse();

        Student.printStudents(students, 2);


        Abonents abonents = new Abonents();
        abonents.add("Павлов", "13123-87687");
        abonents.add("Саблин", "86123-88987");
        abonents.add("Каровин", "76654-87687");
        abonents.add("Воланд", "1873-87687");
        abonents.add("Магарыч", "13123-83387");
        abonents.add("Бездомный", "1313-875337");
        abonents.add("Воланд", "666-999");

        System.out.println("John Conar" + abonents.get("John Conar"));
        System.out.println("Воланд" + abonents.get("Воланд"));
        abonents.printAll();

    }

}
