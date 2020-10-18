package ru.gorinych3.innohomework.homework.task7.part2;

import java.io.*;
import java.util.*;

public class GeneratorText {

    private final String[] arrEndSentence = {". ", "! ", "? "};
    private final int maxSentenceInParagraph = 20;
    private final int maxWordInSentence = 15;
    List<String> words = new ArrayList<>();
    Set<String> usedWords = new HashSet<>();

    public void getFiles(String path, int n, int size, String[] arrWords, int probability) {

        words.addAll(Arrays.asList(arrWords));
        deleteWordsLengthMore15();

        for (int i = 0; i < n; i++) {
            String text = generateText(probability);
            File file = new File(path, "GenText" + i + ".txt");

            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)), size)) {
                bw.append(text);
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String generateText(int probability) {
        StringBuilder text = new StringBuilder();
        for (int x = 0; x < 20; x++) {
            StringBuilder paragraph = new StringBuilder();
            paragraph.append("\t");
            for (int i = 0; i < getRandom(maxSentenceInParagraph); i++) {
                paragraph.append(generateParagraph(probability));
            }
            text.append(paragraph).append("\r\n");
        }
        return text.toString();
    }

    private StringBuilder generateParagraph(int probability) {
        StringBuilder newSentence = new StringBuilder();
        String tmpWord;
        tmpWord = words.get((int) (Math.random() * words.size()));
        tmpWord = Character.toUpperCase(tmpWord.charAt(0)) + tmpWord.substring(1).toLowerCase();
        newSentence.append(tmpWord);
        usedWords.add(tmpWord);
        int sentenceCount = getRandom(maxWordInSentence);
        for (int j = 0; j < sentenceCount; j++) {
            if (isComma() && j != (sentenceCount - 2)) {
                newSentence.append(", ");
            } else {
                newSentence.append(" ");
            }
            while (true) {
                if (getProbabilityWordInNextSentence(probability)) {
                    newSentence.append(words.get((int) (Math.random() * words.size())).toLowerCase());
                    break;
                }
            }
        }
        return newSentence.append(arrEndSentence[(int) (Math.random() * 3)]);
    }

    private void deleteWordsLengthMore15() {
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() > 15) {
                words.remove(words.get(i));
            }
        }
    }

    private boolean getProbabilityWordInNextSentence(int probability) {
        return Math.random() < 1d / probability;
    }

    private int getRandom(int length) {
        return (int) ((Math.random() * length) + 1);
    }

    private boolean isComma() {
        return (Math.random() * 10) < 2;
    }
}
