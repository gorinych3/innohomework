package ru.gorinych3.innohomework.homework.task3.part1;

import java.util.*;

public class MathBox<T extends Number> {

    private List<Number> numberList; //

    private int hashcode;

    public MathBox(T[] arrNumbers) {
        Set<Number> initSet = new HashSet<>(Arrays.asList(arrNumbers));
        numberList = new ArrayList<>(initSet);
        initHashCode();
    }

    public int getHashcode() {
        return hashcode;
    }

    public void setHashcode(int hashcode) {
        this.hashcode = hashcode;
    }

    private void initHashCode() {
        int hash = 0;
        for (Number numb : numberList) {
            hash += numb.hashCode();
        }
        setHashcode(hash);
    }

    public double summator() {
        if (Objects.isNull(this.numberList)) {
            return 0;
        }

        double sum = 0.0;
        for (Number number : numberList) {
            sum += number.doubleValue();
        }
        return sum;
    }

    public <T extends Number> void splitter(T split) {
        if (split.doubleValue() != 0) {
            for (int i = 0; i < numberList.size(); i++) {
                numberList.set(i, numberList.get(i).doubleValue() / split.doubleValue());
            }
        }
    }

    public void deleteInt(Integer integer) {
        numberList.remove(integer);
    }


    public List<Number> getNumberList() {
        return numberList;
    }

    public void setNumberList(List<Number> numberList) {
        this.numberList = numberList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox mathBox = (MathBox) o;
        return Objects.equals(this.numberList, mathBox.numberList);
    }

    @Override
    public int hashCode() {
        return this.getHashcode();
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "listNumbers=" + numberList +
                '}';
    }
}
