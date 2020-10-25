package ru.gorinych3.innohomework.homework.task8.part1;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Optional;

public class FactorialCalculatorRunnableImpl implements Runnable {

    private int num;

    private TempStorage tempStorage;

    public FactorialCalculatorRunnableImpl(int num, TempStorage tempStorage) {
        this.num = num;
        this.tempStorage = tempStorage;
    }


    @Override
    public void run() {
        tempStorage.factorials.put(num, calculateFactorial(num));
    }

    private BigInteger calculateFactorial(int number) {
        BigInteger factorial = BigInteger.ONE;
        if (number == 0) return factorial;
        if (!Objects.equals(tempStorage.factorials.get(number), null)) {
            return tempStorage.factorials.get(number);
        }
        int nearestNumber = getNearestFactorialKey(number);
        int startPosition = 1;
        if (!Objects.equals(nearestNumber, 0)) {
            startPosition = nearestNumber + 1;
            factorial = tempStorage.factorials.get(nearestNumber);
        }
        for (long i = startPosition; i <= number; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        tempStorage.factorials.put(number, factorial);
        return factorial;
    }

    private int getNearestFactorialKey(int currentNumb) {
        final int num = currentNumb;
        Optional<Integer> nearestFactorial = tempStorage.factorials.keySet().stream()
                .filter(x -> x < num)
                .max(Integer::compareTo);
        return nearestFactorial.orElse(0);
    }

}
