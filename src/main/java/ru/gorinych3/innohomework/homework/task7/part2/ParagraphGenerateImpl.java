package ru.gorinych3.innohomework.homework.task7.part2;

import java.util.Random;

public class ParagraphGenerateImpl implements ParagraphGenerate {

    private final int MAX_SENTENCE_IN_PARAGRAPH = 20;

    private int probability;

    private SentenceGenerate sentenceGenerate;

    private Random random = new Random();

    public ParagraphGenerateImpl(int probability, SentenceGenerate sentenceGenerate) {
        this.probability = probability;
        this.sentenceGenerate = sentenceGenerate;
    }

    @Override
    public String generateParagraph() {
        StringBuilder text = new StringBuilder();
        for (int x = 0; x < 20; x++) {
            StringBuilder paragraph = new StringBuilder();
            paragraph.append("\t");
            //int sentenceLenght = (int) ((Math.random() * MAX_SENTENCE_IN_PARAGRAPH) + 1);
            int sentenceLenght = random.nextInt(MAX_SENTENCE_IN_PARAGRAPH) + 1;
            for (int i = 0; i < sentenceLenght; i++) {
                paragraph.append(sentenceGenerate.generateSentence(probability));
            }
            text.append(paragraph).append("\r\n");
        }
        return text.toString();
    }
}
