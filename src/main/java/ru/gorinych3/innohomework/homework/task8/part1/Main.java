package ru.gorinych3.innohomework.homework.task8.part1;

import java.util.Arrays;
import java.util.Random;

/**
 * Дан массив случайных чисел. Написать программу для вычисления факториалов всех элементов массива.
 * Использовать пул потоков для решения задачи.
 * Особенности выполнения:
 * Для данного примера использовать рекурсию - не очень хороший вариант, т.к. происходит большое выделение памяти,
 * очень вероятен StackOverFlow. Лучше перемножать числа в простом цикле при этом создавать объект типа BigInteger
 * По сути, есть несколько способа решения задания:
 * 1) распараллеливать вычисление факториала для одного числа
 * 2) распараллеливать вычисления для разных чисел
 * 3) комбинированный
 * При чем вычислив факториал для одного числа, можно запомнить эти данные и использовать их для вычисления другого,
 * что будет гораздо быстрее
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Integer[] arr = {2, 8, 1, 4, 5, 3, 4};

        Integer[] genArr = generateRandomArr(100);

        System.out.println(Arrays.toString(arr));
        TaskStarterCallable taskStarterCallable = new TaskStarterCallable(arr);
        taskStarterCallable.startTasks();

        System.out.println(Arrays.toString(arr));
        TaskStarterRunnable taskStarterRunnable = new TaskStarterRunnable(arr);
        taskStarterRunnable.startTasks();
    }

    private static Integer[] generateRandomArr(int size) {
        Integer[] numbers = new Integer[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = Math.abs(new Random().nextInt(10000));
        }
        return numbers;
    }
}
