package ru.gorbachev.javacore.lesson3;

import ru.gorbachev.javacore.lesson3.controller.SearchRepeating;
import ru.gorbachev.javacore.lesson3.essence.ListWord;

import java.util.ArrayList;

public class Lesson3 {
    public static void main(String[] args) {
        //Поиск совпадений слов
        ListWord listWord = new ListWord();
        SearchRepeating searchRepeating = new SearchRepeating(listWord.getArrayWord());
        searchRepeating.searchDuplicate();
        System.out.println(searchRepeating.toString());
    }
}
