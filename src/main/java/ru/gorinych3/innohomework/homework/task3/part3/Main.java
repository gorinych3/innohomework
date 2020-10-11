package ru.gorinych3.innohomework.homework.task3.part3;

import java.util.ArrayList;
import java.util.List;

/**
 * Задание 3. Доработать классы MathBox и ObjectBox таким образом, чтобы MathBox был наследником ObjectBox.
 * Необходимо сделать такую связь, правильно распределить поля и методы. Функциональность в целом должна сохраниться.
 * При попытке положить Object в MathBox должно создаваться исключение.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        Number[] numbers1 = {1, 2L, 3.0, 4.5, 5};

        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");

        MathBox mathBox = new MathBox<>(numbers1);

        mathBox.dump();

        System.out.println(mathBox.summator());

        mathBox.deleteInt(5);

        mathBox.dump();

        mathBox.splitter(2);

        mathBox.dump();

        ObjectBox objectBox = new ObjectBox();

        objectBox.setCollection(stringList);

        objectBox.addObject("456");

        objectBox.dump();

        objectBox.deleteObject("3");

        objectBox.dump();

        mathBox.addObject(5);

        mathBox.dump();
    }
}
