package ru.gorinych3.innohomework.homework.task10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleReader {

    public static List<String> readLines() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while (!(line = bf.readLine()).isEmpty()) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
