package Lesson_6;

public class Dog extends Animal {

    int maxJamp = 5;
    int maxRun = 500;
    int maxSwim = 10;
    private static int countDogs = 0;
    public Dog(){
        countDogs++;
    }
    public static int getCountDogs(){
        return countDogs;
    }

    @Override
    public void jamp(String name, int heightJump) {
        if (heightJump <= maxJamp)
            System.out.println(name + " прыгнул " + heightJump + " м ");
        else
            System.out.println(name + " не прыгнул " + heightJump + " м ");
    }

    @Override
    public void run(String name, int distRun){
        if (distRun <= maxRun)
            System.out.println(name + " пробежал " + distRun + " м ");
        else
            System.out.println(name + " не пробежал " + distRun + " м ");
    }

    @Override
    public void swim(String name, int distSwim) {
        if (distSwim <= maxSwim)
            System.out.println(name + " проплыл " + distSwim + " м ");
        else
            System.out.println(name + " не проплыл " + distSwim + " м ");
    }

}
