package Lesson_9;
/*
Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи,
а с помощью метода get() искать номер телефона по фамилии.
Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
тогда при запросе такой фамилии должны выводиться все телефоны.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Abonents {
    private Map<String, List<String>> abonents;

    public Abonents() {
        this.abonents = new HashMap<>();
    }
    public void add (String Name, String phoneNumber){
        abonents.putIfAbsent(Name, new ArrayList<>());
        abonents.get(Name).add(phoneNumber);
    }

    public List<String> get(String lastName) {
        return abonents.getOrDefault(lastName, new ArrayList<>());
    }


    public void printAll() {
        for (Map.Entry<String, List<String>> entry : abonents.entrySet()) {
            System.out.println("Фамилия: " + entry.getKey() + " | Телефоны: " + entry.getValue());
        }
    }
    }
