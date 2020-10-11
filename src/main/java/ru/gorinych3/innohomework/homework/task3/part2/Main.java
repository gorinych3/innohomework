package ru.gorinych3.innohomework.homework.task3.part2;

import ru.gorinych3.innohomework.homework.task3.part1.MathBox;

import java.util.*;

/**
 * Задание 2. Создать класс ObjectBox, который будет хранить коллекцию Object.
 * У класса должен быть метод addObject, добавляющий объект в коллекцию.
 * У класса должен быть метод deleteObject, проверяющий наличие объекта в коллекции и при наличии удаляющий его.
 * Должен быть метод dump, выводящий содержимое коллекции в строку.
 */
public class Main {

    public static void main(String[] args) {

        ObjectBox objectBox = new ObjectBox();
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        objectBox.setCollection(strings);

        Number[] numbers1 = {1, 2L, 3.0, 4.5, 5};
        Set<Number> numberSet = new HashSet<>();
        numberSet.add(11);
        numberSet.add(12);
        numberSet.add(13);

        objectBox.dump();

        objectBox.addObject("4");
        objectBox.addObject(new Integer(5));
        objectBox.addObject(new MathBox<>(numbers1));

        objectBox.dump();

        objectBox.deleteObject("3");
        objectBox.deleteObject(new MathBox<>(numbers1));

        objectBox.dump();

        objectBox.setCollection(numberSet);
        objectBox.addObject(13);

        objectBox.dump();

    }
}
