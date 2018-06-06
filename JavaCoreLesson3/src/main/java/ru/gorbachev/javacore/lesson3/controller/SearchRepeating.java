package ru.gorbachev.javacore.lesson3.controller;
//Класс, реализующий поиск в объекте ListWord на предмет повторяющихся слов

import java.util.*;

public class SearchRepeating {

    private List<String> arrayWord = new ArrayList<String>();
    private Map<String, Integer> result = new HashMap<String, Integer>();

    public SearchRepeating(List<String> arrayWord) {
        this.arrayWord = arrayWord;
    }

    public void searchDuplicate() {
        Set<String> tmpSet = new HashSet<String>();
        for (int i = 0; i < this.arrayWord.size(); i++) {
            if (!tmpSet.add(this.arrayWord.get(i))) {
                if (result.containsKey(this.arrayWord.get(i))) {
                    result.put(this.arrayWord.get(i), result.get(this.arrayWord.get(i)) + 1);
                } else {
                    result.put(this.arrayWord.get(i), 1);
                }
            }
        }
    }

    @Override
    public String toString() {
        String resultStrnig = "";
        if (this.result.size() != 0) {
            for (String key : this.result.keySet()) {
                resultStrnig += "Слово '" + key + "' повторилось " + this.result.get(key) + " раз";
            }
        } else {
            resultStrnig += "Совпадений не найдено";
        }
        return resultStrnig;
    }
}
