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

    }

}
