package ru.gorinych3.innohomework.homework.task10;

import java.io.*;

public class CustomFileWriter {

    private CustomFileWriter() {
    }

    public static void write2JavaFile(File file, String textFile) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)))) {
            bw.write(textFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
