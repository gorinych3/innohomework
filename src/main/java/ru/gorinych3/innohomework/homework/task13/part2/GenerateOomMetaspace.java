package ru.gorinych3.innohomework.homework.task13.part2;

import javassist.ClassPool;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Задание 2.     Доработать программу так, чтобы ошибка OutOfMemoryError возникала в Metaspace /Permanent Generation
 * <p>
 * Примечание - необходимо установить параметр JVM -XX:MaxMetaspaceSize=64m
 */
public class GenerateOomMetaspace {

    private static final Logger LOG = LogManager.getLogger(GenerateOomMetaspace.class.getName());
    static ClassPool classPool = ClassPool.getDefault();

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 1000000000; i++) {
            Class clazz = classPool.makeClass("Permgen" + i).toClass();
            LOG.info(clazz.getName());
        }
    }
}
