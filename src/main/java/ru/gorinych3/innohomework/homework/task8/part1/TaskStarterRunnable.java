package ru.gorinych3.innohomework.homework.task8.part1;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class TaskStarterRunnable {

    private Integer[] numbers;

    public TaskStarterRunnable(Integer[] arrNumbers) {
        this.numbers = arrNumbers;
    }

    public void startTasks() throws InterruptedException {
        long startMills = new Date().getTime();
        final ExecutorService executorService = Executors.newFixedThreadPool(4);
        TempStorage tempStorage = new TempStorage();
        for (int i = 0; i < numbers.length; i++) {
            FactorialCalculatorRunnableImpl factorialCalculatorRunnableImpl = new FactorialCalculatorRunnableImpl(numbers[i], tempStorage);
            executorService.submit(factorialCalculatorRunnableImpl);
        }
        executorService.shutdown();

        sleep(3000);
        tempStorage.factorials.forEach((key, value) -> {
            System.out.println("key: " + key + "   value: " + value);
        });
        System.out.println(new Date().getTime() - startMills);
    }

}
