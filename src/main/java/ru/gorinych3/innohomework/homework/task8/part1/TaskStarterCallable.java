package ru.gorinych3.innohomework.homework.task8.part1;

import java.math.BigInteger;
import java.util.Date;
import java.util.concurrent.*;

public class TaskStarterCallable {

    private Integer[] numbers;
    private ConcurrentHashMap<Integer, Future<BigInteger>> futures = new ConcurrentHashMap<>();

    public TaskStarterCallable(Integer[] arrNumbers) {
        this.numbers = arrNumbers;
    }

    public void startTasks() {
        long startMills = new Date().getTime();
        final ExecutorService executorService = Executors.newFixedThreadPool(4);
        TempStorage tempStorage = new TempStorage();
        for (int i = 0; i < numbers.length; i++) {
            FactorialCalculatorCallableImpl factorialCalculatorCallableImpl = new FactorialCalculatorCallableImpl(numbers[i], tempStorage);
            futures.put(numbers[i], executorService.submit(factorialCalculatorCallableImpl));
        }

        executorService.shutdown();
        futures.forEach((key, value) -> {
            try {
                System.out.println("key: " + key + "   value: " + value.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        System.out.println(new Date().getTime() - startMills);
    }
}
