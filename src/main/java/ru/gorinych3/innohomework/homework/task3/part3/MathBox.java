package ru.gorinych3.innohomework.homework.task3.part3;

import java.util.*;

public class MathBox<T extends Number> extends ObjectBox {


    public MathBox(T[] arrNumbers) {
        Set<Number> initSet = new HashSet<>(Arrays.asList(arrNumbers));
        setCollection(new ArrayList<>(initSet));
    }

    public Number summator() {
        if (getCollection() == null) {
            return 0;
        }

        double sum = 0.0;
        for (Object number : getCollection()) {
            sum += ((Number) number).doubleValue();
        }
        return sum;
    }

    public <T extends Number> void splitter(T split) {
        if (split.intValue() != 0) {
            List<Number> numberList = (List<Number>) getCollection();
            for (int i = 0; i < getCollection().size(); i++) {
                numberList.set(i, numberList.get(i).doubleValue() / split.doubleValue());
            }
        }
    }

    @Override
    public void addObject(Object object) throws Exception {
        throw new Exception();
    }

    public void deleteInt(Integer integer) {
        deleteObject(integer);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox mathBox = (MathBox) o;
        return Objects.equals(getCollection(), mathBox.getCollection());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCollection());
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "listNumbers=" + getCollection() +
                '}';
    }
}
