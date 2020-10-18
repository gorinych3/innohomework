package ru.gorinych3.innohomework.homework.task7.part1;

/**
 * Написать программу, читающую текстовый файл. Программа должна составлять отсортированный по алфавиту список слов,
 * найденных в файле и сохранять его в файл-результат. Найденные слова не должны повторяться, регистр не должен
 * учитываться. Одно слово в разных падежах – это разные слова.
 */
public class Main {

    public static void main(String[] args) {
        ReadTextSortWriteWords writeWords = new ReadTextSortWriteWords("inputText.txt", "outputText.txt");

        writeWords.start();

        writeWords.printSetStrings();

        writeWords.printWords();
    }
}
