package ru.gorinych3.innohomework.homework.task2.part1;

/**
 * Написать программу ”Hello, World!”. В ходе выполнения программы она должна выбросить исключение и завершиться с ошибкой.
 * <p>
 * Смоделировав ошибку «NullPointerException»
 * Смоделировав ошибку «ArrayIndexOutOfBoundsException»
 * Вызвав свой вариант ошибки через оператор throw
 */
public class Main {

    public static void main(String[] args) {

        Main main = new Main();

        main.printHelloWorldWithNPE();
        main.printHelloWorldWithOutBoundEx();
        main.generateArithmeticException();
    }

    private void printHelloWorldWithNPE() {

        HelloWorld helloWorld = null;

        helloWorld.setHello("Hello, World!");
        System.out.println(helloWorld.getHello());
    }

    private void printHelloWorldWithOutBoundEx() {

        HelloWorld helloWorld = new HelloWorld();

        helloWorld.setHello("Hello, World!");
        char[] charsHelloFieldValue = helloWorld.getHello().toCharArray();
        System.out.println(charsHelloFieldValue[charsHelloFieldValue.length + 1]);
    }

    private void generateArithmeticException() {

        throw new ArithmeticException();
    }
}
