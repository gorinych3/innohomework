package ru.gorinych3.innohomework.homework.task10;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomFileReader {

    private CustomFileReader() {
    }

    public static List<String> readFile(File file) {
        List<String> interfaceAsStrings = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file)))) {

            while (br.ready()) {
                interfaceAsStrings.add(br.readLine() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return interfaceAsStrings;
    }
}
