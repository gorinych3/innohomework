package ru.gorinych3.innohomework.homework.task10;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {

    final Logger log = LogManager.getLogger(this.getClass().getName());

    @Override
    protected Class<?> findClass(String name) {
        File classFile = new File(name + ".class");

        try (BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(classFile))) {
            byte[] content = new byte[(int) classFile.length()];
            bis.read(content);

            return defineClass(name, content, 0, content.length);
        } catch (IOException e) {
            log.error("exception in classloader");
            log.error(e.getMessage());
            return null;
        }
    }
}
