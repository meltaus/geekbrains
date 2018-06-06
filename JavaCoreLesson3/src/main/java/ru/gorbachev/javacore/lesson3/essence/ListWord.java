package ru.gorbachev.javacore.lesson3.essence;
//Объект который загружает в себя случайное количество слов (10-20) из ресурса book.txt из случайного места, но подряд.


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ListWord {

    private List<String> arrayWord = new ArrayList<String>();

    public ListWord() {
        //Публичным будет только конструктор и toString.
        ClassLoader classLoader = getClass().getClassLoader();
        String path = classLoader.getResource("book.txt").getPath();
        this.readResource(path);
    }

    //Загружаем текстовый файл, читаем оттуда рандомную строку
    //Строка выбирается путем выбора случайного байта из размера всего файла.
    //Если в строе меньше 10 слов - добавляется еще одна строка. Если получилось больше 20 - удалаются лишние
    // справа
    private void readResource(String path) {
        try {
            String randomString = "";
            do {
                BufferedReader reader = new BufferedReader(new FileReader(path));
                List<String> lines = new ArrayList<String>();

                String line = reader.readLine();

                while (line != null) {
                    lines.add(line);
                    line = reader.readLine();
                }

                Random r = new Random();
                randomString = lines.get(r.nextInt(lines.size()));
                randomString = randomString.replaceAll("[^a-zA-Zа-яА-Я]", " ");
                randomString = randomString.replaceAll("[\\s]{2,}", " ");
                arrayWord = Arrays.asList(randomString.split("\\s"));
                if (arrayWord.size() > 20) {
                    List<String> sublist = arrayWord.subList(0,20); // Удаляем с 2 по 4й элемент включительно
//                    arrayWord.removeAll(sublist);
                    arrayWord = sublist;
                }
            } while (arrayWord.size() < 10);
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
