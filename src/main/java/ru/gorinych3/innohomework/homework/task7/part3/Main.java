package ru.gorinych3.innohomework.homework.task7.part3;

/**
 * Задание-бонус: напишите простую программу, которая читает файл в кодировке UTF-8, а пишет в другой файл в
 *  кодировке UTF-16. Использовать InputStreamReader/OutputStreamWriter
 */
public class Main {

    public static void main(String[] args) {

        ChangeEncoding changeEncoding = new ChangeEncoding();

        changeEncoding.utf8ToUtf16("russianWordsIn.txt", "russianWordsOut.txt");

    }
}
