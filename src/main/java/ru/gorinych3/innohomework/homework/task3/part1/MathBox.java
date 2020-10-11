package ru.gorinych3.innohomework.homework.task3.part1;

import java.util.*;

public class MathBox<T extends Number> {

    private List<Number> numberList; //

    public MathBox(T[] arrNumbers) {
        Set<Number> initSet = new HashSet<>(Arrays.asList(arrNumbers));
        numberList = new ArrayList<>(initSet);
    }

    public Number summator() {
        if (this.numberList == null) {
            return 0;
        }

        double sum = 0.0;
        for (Number number : numberList) {
            sum += number.doubleValue();
        }
        return sum;
    }

    public <T extends Number> void splitter(T split) {
        if (split.intValue() != 0) {
            for (int i = 0; i < numberList.size(); i++) {
                numberList.set(i, numberList.get(i).doubleValue() / split.doubleValue());
            }
        }
    }

    public void deleteInt(Integer integer) {
        ListIterator<? extends Number> listIterator = this.numberList.listIterator();

        while (listIterator.hasNext()) {
            Object object = listIterator.next();
            if (object.getClass() == Integer.class) {
                if (object.equals(integer)) {
                    listIterator.remove();
                }
            }
        }
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
        return Objects.equals(numberList, mathBox.numberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberList);
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "listNumbers=" + numberList +
                '}';
    }
}
