package Lesson_6;
/*
Создать классы Собака и Кот с наследованием от класса Животное.
Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); → Бобик пробежал 150 м.);
У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).

Добавить подсчет созданных котов, собак и животных.

 */
public class Animal {

    public void jamp(String name, int heightJump){};
    public void run(String name, int distRun){};
    public void swim(String name, int distSwim){};
    private static int countAnimals = 0;
    public Animal(){
        countAnimals++;
    }
    public static int getCountAnimals(){
        return countAnimals;
    }


}
