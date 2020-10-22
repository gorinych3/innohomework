package ru.gorinych3.innohomework.homework.task7.part2;

import java.util.Random;

public class SentenceGenerateImpl implements SentenceGenerate {

    private final String[] ARR_END_SENTENCE = {". ", "! ", "? "};
    private final int MAX_WORD_IN_SENTENCE = 15;
    private WordGenerate wordGenerate;

    private Random random = new Random();

    public SentenceGenerateImpl(WordGenerate wordGenerate) {
        this.wordGenerate = wordGenerate;
    }

    @Override
    public StringBuilder generateSentence(int probability) {
        StringBuilder newSentence = new StringBuilder();
        String tmpWord;
        tmpWord = wordGenerate.getWord();
        tmpWord = Character.toUpperCase(tmpWord.charAt(0)) + tmpWord.substring(1).toLowerCase();
        newSentence.append(tmpWord);
        int sentenceCount = getRandom(MAX_WORD_IN_SENTENCE);
        for (int j = 0; j < sentenceCount; j++) {
            if (isComma() && j != (sentenceCount - 2)) {
                newSentence.append(", ");
            } else {
                newSentence.append(" ");
            }
            while (true) {
                if (getProbabilityWordInNextSentence(probability)) {
                    newSentence.append(wordGenerate.getWord());
                    break;
                }
            }
        }
        return newSentence.append(ARR_END_SENTENCE[random.nextInt(3)]);
    }

    private boolean getProbabilityWordInNextSentence(int probability) {
        return random.nextDouble() < 1d / probability;
    }

    private int getRandom(int length) {
        return random.nextInt(length) + 1;
    }

    private boolean isComma() {
        return random.nextInt(10) < 2;
    }
}
