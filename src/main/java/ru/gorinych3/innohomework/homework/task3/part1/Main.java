package ru.gorinych3.innohomework.homework.task3.part1;

import java.util.HashSet;
import java.util.Set;

/**
 * Задание 1. Написать класс MathBox, реализующий следующий функционал:
 * <p>
 * Конструктор на вход получает массив Number. Элементы не могут повторяться. Элементы массива внутри объекта
 * раскладываются в подходящую коллекцию (выбрать самостоятельно).
 * Существует метод summator, возвращающий сумму всех элементов коллекции.
 * Существует метод splitter, выполняющий поочередное деление всех хранящихся в объекте элементов на делитель,
 * являющийся аргументом метода. Хранящиеся в объекте данные полностью заменяются результатами деления.
 * Необходимо правильно переопределить методы toString, hashCode, equals, чтобы можно было использовать MathBox
 * для вывода данных на экран и хранение объектов этого класса в коллекциях (например, hashMap).
 * Выполнение контракта обязательно!
 * Создать метод, который получает на вход Integer и если такое значение есть в коллекции, удаляет его.
 */
public class Main {

    public static void main(String[] args) {


        Number[] numbers1 = {1, 2L, 3.0f, 4.5, 5};

        Number[] numbers2 = {1, 2L, 3.0f, 4.5, 5};

        MathBox<Number> mathBox1 = new MathBox<>(numbers1);
        MathBox<Number> mathBox2 = new MathBox<>(numbers2);

        System.out.println("method toString and hashCode");
        System.out.println(mathBox1.toString());
        System.out.println(mathBox1.hashCode());
        System.out.println();

        System.out.println("method equals and hashCode");
        System.out.println(mathBox1.equals(mathBox2));
        System.out.println(mathBox1.hashCode());
        System.out.println(mathBox2.hashCode());
        System.out.println();

        System.out.println("method summator");
        System.out.println(mathBox1.summator());
        System.out.println(mathBox1.toString());
        System.out.println(mathBox1.hashCode());
        System.out.println();

        System.out.println("method splitter");
        mathBox1.splitter(2);
        System.out.println(mathBox1.toString());
        System.out.println(mathBox1.hashCode());
        System.out.println();

        System.out.println("method deleteInt");
        mathBox1.deleteInt(3);
        System.out.println(mathBox1.toString());
        System.out.println(mathBox1.hashCode());

        new Main().checkDuplicateHashCode();
    }

    /**
     * проверка, сколько дубликатов хэша появится при определении хэшкода методом, который сгенерировала IDEA
     */
    private void checkDuplicateHashCode() {
        System.out.println("method checkDuplicateHashCode from 4_000_000 objects");
        Set<Integer> hashs = new HashSet<>();
        long maxCountMathBox = 5_000_000L;
        for (long i = 0; i < maxCountMathBox; i++) {
            hashs.add(new MathBox<>(new Number[]{1, 2L, 3.0, 4.5, 5 + i}).hashCode());
        }

        System.out.println(hashs.size());
        System.out.println(maxCountMathBox - hashs.size());
    }
}
