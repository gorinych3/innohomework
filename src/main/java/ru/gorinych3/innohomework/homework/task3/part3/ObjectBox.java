package ru.gorinych3.innohomework.homework.task3.part3;

import java.util.Collection;

public class ObjectBox<T> {

    private Collection<T> collection;

    public void addObject(T object) throws Exception {
        if (collection != null) {
            collection.add(object);
        }
    }

    public void dump() {
        System.out.println(this.collection.toString());
    }

    public void deleteObject(T object) {
        if (collection != null) {
            collection.remove(object);
        }
    }

    public Collection<T> getCollection() {
        return collection;
    }

    public void setCollection(Collection<T> collection) {
        this.collection = collection;
    }
}
