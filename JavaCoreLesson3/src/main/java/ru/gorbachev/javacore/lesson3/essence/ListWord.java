package ru.gorbachev.javacore.lesson3.essence;
//Объект который загружает в себя случайное количество слов (10-20) из ресурса book.txt из случайного места, но подряд.


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class ListWord {

    private List<String> arrayWord = new ArrayList<String>();

    public ListWord() {
        //Публичным будет только конструктор и toString.
        this.readResource();
    }

    //Загружаем текстовый файл, читаем оттуда рандомную строку
    //Строка выбирается путем выбора случайного байта из размера всего файла.
    //Если в строе меньше 10 слов - добавляется еще одна строка. Если получилось больше 20 - удалаются лишние
    // справа
    private void readResource() {
        File file = new File("/resources/book.txt");
        RandomAccessFile randomAccessFile;

        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            long file_size = file.length();
            long choosen_byte = (long)(Math.random() * file_size);

            randomAccessFile.seek(choosen_byte);

            for (;;) {
                byte a_byte = randomAccessFile.readByte();
                char wordChar = (char)a_byte;
                if (choosen_byte >= file_size || wordChar == '\n' || wordChar == '\r' || wordChar == -1) {
                    break;
                } else {
                    choosen_byte++;
                }
                System.out.println("\"" + Character.toString(wordChar)  + "\"");
            }

            int choosen = -1;

            if (choosen_byte < file_size) {
                String s = randomAccessFile.readLine();
                System.out.println("Chosen id : \"" + s  + "\"");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
