package ru.gorinych3.innohomework.homework.task7.part1;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ReadTextSortWriteWords {

    Set<String> strings = new HashSet<>();
    Set<String> words = new TreeSet<>();
    private String readFileName;
    private String writeFileName;


    public ReadTextSortWriteWords(String readFileName, String writeFileName) {
        this.readFileName = readFileName;
        this.writeFileName = writeFileName;
    }

    public void start() {
        readText();

        splitWords();

        writeWords2outFile();
    }


    private void readText() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(getReadFileName())))) {
            while (br.ready()) {
                strings.add(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void splitWords() {
        String changedString;
        for (String str : strings) {
            changedString = str.toLowerCase();
            changedString = changedString.replaceAll("[^a-zA-Z\\s]", "");
            String[] splitWord = changedString.split(" ");
            words.addAll(Arrays.asList(splitWord));
        }
    }


    private void writeWords2outFile() {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(getWriteFileName())))) {
            for (String word : words){
                bw.write(word + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printSetStrings() {
        for (String str : strings) {
            System.out.println(str);
        }
    }

    public void printWords() {
        for (String word : words) {
            System.out.println(word);
        }
        System.out.println();
        System.out.println("words.size(): " + words.size());
    }

    public String getReadFileName() {
        return readFileName;
    }

    public void setReadFileName(String readFileName) {
        this.readFileName = readFileName;
    }

    public String getWriteFileName() {
        return writeFileName;
    }

    public void setWriteFileName(String writeFileName) {
        this.writeFileName = writeFileName;
    }
}
