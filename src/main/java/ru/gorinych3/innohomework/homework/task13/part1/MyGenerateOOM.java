package ru.gorinych3.innohomework.homework.task13.part1;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class MyGenerateOOM {

    private static final Logger LOG = LogManager.getLogger(MyGenerateOOM.class.getName());

    private final List<MyObject> myObjects = new ArrayList<>();

    public void addList() {
        LOG.info("Start adding");
        for (int i = 1; i < 2_100_000_000; i *= 10) {
            myObjects.add(new MyObject(i));
            if (i % 100 == 0) {
                delObjectsFromList();
            }
        }
    }

    public void delObjectsFromList() {
        LOG.info("Start deleting");
        for (int i = 0; i < myObjects.size() / 10; i++) {
            myObjects.set(i, null);
        }
        LOG.info("List size = " + myObjects.size());
        LOG.info("last arr size = " + myObjects.get(myObjects.size() - 1).getArr().length);
        LOG.info("Free Memory: " + Runtime.getRuntime().freeMemory());
    }
}
