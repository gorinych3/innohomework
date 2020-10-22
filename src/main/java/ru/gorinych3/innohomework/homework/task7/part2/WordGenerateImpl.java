package ru.gorinych3.innohomework.homework.task7.part2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class WordGenerateImpl implements WordGenerate {

    private List<String> words = new ArrayList<>();

    public WordGenerateImpl(String[] arrWords) {
        Collections.addAll(words, arrWords);
    }

    @Override
    public String getWord() {
        return words.get(new Random().nextInt(words.size())).toLowerCase();
    }
}
