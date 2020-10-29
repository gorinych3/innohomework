package ru.gorinych3.innohomework.homework.task10;

/**
 * Дан интерфейс
 * <p>
 * public interface Worker {
 * void doWork();
 * }
 * <p>
 * Необходимо написать программу, выполняющую следующее:
 * <p>
 * Программа с консоли построчно считывает код метода doWork. Код не должен требовать импорта дополнительных классов.
 * После ввода пустой строки считывание прекращается и считанные строки добавляются в тело метода public void doWork()
 * в файле SomeClass.java.
 * Файл SomeClass.java компилируется программой (в рантайме) в файл SomeClass.class.
 * Полученный файл подгружается в программу с помощью кастомного загрузчика
 * Метод, введенный с консоли, исполняется в рантайме (вызывается у экземпляра объекта подгруженного класса)
 * <p>
 * 1. Считать строки из консоли (тело метода)
 * 2. Считать файл интерфейса построчно
 * 3. Найти якорь (строка с заголовком метода) заменить ; на {строки из консоли}
 * 4. Записать строки в новый файл SomeClass.java
 * 5. Скомпилировать файл SomeClass.java в SomeClass.class
 * 6. Загрузить SomeClass.class кастомным загрузчиком (MyClassLoader)
 * 7. Вызвать метод doWork у нового класса
 * <p>
 * int a = 5;int b = 7;System.out.println(a + b);
 **/

public class Main {

    public static void main(String[] args) {

        FileService fileService = new FileService("Worker", "SomeClass");
        fileService.startProcess();

    }
}
