package ru.gorinych3.innohomework.homework.task3.part2;

import java.util.Collection;

public class ObjectBox {

    private Collection<Object> collection;

    public void addObject(Object object) {
        if (collection != null) {
            collection.add(object);
        }
    }

    public void dump() {
        System.out.println(this.collection.toString());
    }

    public void deleteObject(Object object) {
        if (collection != null) {
            collection.remove(object);
        }
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }
}
