package ru.gorinych3.innohomework.homework.task7.part2;

public class ParagraphGenerateImpl implements ParagraphGenerate {

    private final int maxSentenceInParagraph = 20;

    private int probability;

    private SentenceGenerate sentenceGenerate;

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
            int sentenceLenght = (int) ((Math.random() * maxSentenceInParagraph) + 1);
            for (int i = 0; i < sentenceLenght; i++) {
                paragraph.append(sentenceGenerate.generateSentence(probability));
            }
            text.append(paragraph).append("\r\n");
        }
        return text.toString();
    }
}
