package ru.gorbachev.javacore.lesson3;

import ru.gorbachev.javacore.lesson3.controller.SearchRepeating;
import ru.gorbachev.javacore.lesson3.essence.ListWord;
import ru.gorbachev.javacore.lesson3.essence.Phonebook;

import java.util.ArrayList;

public class Lesson3 {
    public static void main(String[] args) {
        //Поиск совпадений слов
        ListWord listWord = new ListWord();
        SearchRepeating searchRepeating = new SearchRepeating(listWord.getArrayWord());
        searchRepeating.searchDuplicate();
        System.out.println(searchRepeating.toString() + "\n");

        Phonebook phonebook = new Phonebook();
        phonebook.add("Горбачев", 777777);
        phonebook.add("Горбачев", 888888);
        phonebook.add("Губанов", 4654654);
        phonebook.add("Первушин", 1312314);
        phonebook.add("Первушин", 1231569);
        phonebook.add("Первушин", 123156);

        System.out.println(phonebook.get("Горбачев"));
        System.out.println(phonebook.get("Первушин"));
        System.out.println(phonebook.get("Артем"));
    }
}
