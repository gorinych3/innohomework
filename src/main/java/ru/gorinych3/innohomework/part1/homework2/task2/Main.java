package ru.gorinych3.innohomework.part1.homework2.task2;

/**
 * Составить программу, генерирующую N случайных чисел. Для каждого числа k вычислить квадратный корень q.
 * Если квадрат целой части q числа равен k, то вывести это число на экран.
 * Предусмотреть что первоначальные числа могут быть отрицательные, в этом случае генерировать исключение.
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();

        int arrSize = 100;
        int maxValue = 100;

        main.mathOperationsPrintResult(main.generateArrNumbers(arrSize, maxValue));
    }

    private int[] generateArrNumbers(int arrSize, int maxValue) {

        int [] resultArrRandomNumbers = new int[arrSize];
        for(int i = 0; i < arrSize; i++){
            resultArrRandomNumbers[i] = (int) (Math.random() * maxValue);
        }
        return resultArrRandomNumbers;
    }

    private void mathOperationsPrintResult(int [] randomNumbers) {
        for(int randomNumber : randomNumbers) {
            if(randomNumber >= 0){
                if((int)(Math.sqrt(randomNumber)) * (int)(Math.sqrt(randomNumber)) == randomNumber) {
                    System.out.println(randomNumber);
                }
            } else throw new ArithmeticException();
        }
    }
}
