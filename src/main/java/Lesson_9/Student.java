package Lesson_9;
/*
Создайте класс Student, содержащий следующие характеристики – имя, группа, курс, оценки по предметам.
Создайте коллекцию, содержащую объекты класса Student.
Следует написать метод, который удаляет студентов со средним баллом < 3, а также отдельный метод,
который переводит студента на следующий курс, если средний балл >= 3.
Напишите метод printStudents(Set<Student> students, int course),
который получает список студентов и номер курса.
Метод печатает на консоль имена тех студентов, которые обучаются на данном курсе.
 */

import java.util.LinkedList;

public class Student {
    private String name;
    private String group;
    private int course;
    LinkedList<Integer> grade;
    double bal = 0;

    public Student(String name, String group, int course, LinkedList<Integer> grade){
        this.name = name;
        this.group = group;
        this.course = course;
        this.grade = grade;
    }

    public double averageGrade () {
        return bal = grade.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public void transferToCourse() {
        if (bal >= 3.0)
            course ++;
    }
}
