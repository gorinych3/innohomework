package ru.gorinych3.innohomework.homework.task13.part1;

/**
 * Задание 1.     Необходимо создать программу, которая продемонстрирует утечку памяти в Java. При этом объекты
 * должны не только создаваться, но и периодически частично удаляться, чтобы GC имел возможность очищать
 * часть памяти. Через некоторое время программа должна завершиться с ошибкой OutOfMemoryError
 * c пометкой Java Heap Space.
 */
public class Main {

    public static void main(String[] args) {

        MyGenerateOOM myGenerateOOM = new MyGenerateOOM();
        myGenerateOOM.addList();
    }
}
