package ru.gorinych3.innohomework.homework.task7.part2;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

public class WordGenerateImpl implements WordGenerate {

    private List<String> words;

    public WordGenerateImpl(String[] arrWords) {
        this.words = Arrays.asList(arrWords);
    }

    @Override
    public String getWordFromList() {
        return words.get((int) (Math.random() * words.size())).toLowerCase();
    }

    @PostConstruct
    public void deleteWordsLengthMore15() {
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() > 15) {
                System.out.println(words.get(i));
                words.remove(words.get(i));
            }
        }
    }
}
