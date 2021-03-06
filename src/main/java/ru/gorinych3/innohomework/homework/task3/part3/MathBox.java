package ru.gorinych3.innohomework.homework.task3.part3;

import java.util.*;

public class MathBox<T extends Number> extends ObjectBox<T> {

    private int hashcode;

    public MathBox(T[] arrNumbers) {
        Set<T> initSet = new HashSet<>(Arrays.asList(arrNumbers));
        setCollection(new ArrayList<>(initSet));
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
        for (Number numb : getCollection()) {
            hash += numb.hashCode();
        }
        setHashcode(hash);
    }

    public Double summator() {
        if (getCollection() == null) {
            return 0d;
        }

        double sum = 0.0;

        for (Object number : getCollection()) {
            sum += ((T) number).doubleValue();
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
    public void addObject(T object) throws Exception {
        //throw new Exception();
        getCollection().add(object);
    }

    public void deleteInt(Integer integer) {
        deleteObject((T) integer);
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
        return getHashcode();
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "listNumbers=" + getCollection() +
                '}';
    }
}
