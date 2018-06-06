package ru.gorbachev.javacore.lesson3.essence;
//Класс, реализующий объект телефонный справочник.

import java.util.ArrayList;
import java.util.HashMap;

public class Phonebook {

    private HashMap<String, ArrayList<Integer>> phone = new HashMap<String, ArrayList<Integer>>();

    public Phonebook() {

    }

    public void add(String name, Integer number) {
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        if (this.phone.containsKey(name)) {
            tmp = this.phone.get(name);
            tmp.add(number);
            this.phone.put(name, new ArrayList<Integer>(tmp));
        } else {
            tmp.add(number);
            this.phone.put(name, tmp);
        }
    }

    public String get(String name) {
        String resultString = "";
        if (this.phone.containsKey(name)) {
            ArrayList<Integer> result = new ArrayList<Integer>(this.phone.get(name));
            resultString += "По фамилии " + name + " следущие совпадения: \n";
            for (int i = 0; i < result.size(); i++) {
                resultString += "Телефонный номер " + i + ": " + result.get(i) + "\n";
            }
        } else {
            resultString = "Совпадений не найдено";
        }
        return resultString;
    }
}
