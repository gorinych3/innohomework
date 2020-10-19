package ru.gorinych3.innohomework.homework.task7.part2;

public class SentenceGenerateImpl implements SentenceGenerate {

    private final String[] arrEndSentence = {". ", "! ", "? "};
    private final int maxWordInSentence = 15;
    private WordGenerate wordGenerate;

    public SentenceGenerateImpl(WordGenerate wordGenerate) {
        this.wordGenerate = wordGenerate;
    }

    @Override
    public StringBuilder generateSentence(int probability) {
        StringBuilder newSentence = new StringBuilder();
        String tmpWord;
        tmpWord = wordGenerate.getWordFromList();
        tmpWord = Character.toUpperCase(tmpWord.charAt(0)) + tmpWord.substring(1).toLowerCase();
        newSentence.append(tmpWord);
        int sentenceCount = getRandom(maxWordInSentence);
        for (int j = 0; j < sentenceCount; j++) {
            if (isComma() && j != (sentenceCount - 2)) {
                newSentence.append(", ");
            } else {
                newSentence.append(" ");
            }
            while (true) {
                if (getProbabilityWordInNextSentence(probability)) {
                    newSentence.append(wordGenerate.getWordFromList());
                    break;
                }
            }
        }
        return newSentence.append(arrEndSentence[(int) (Math.random() * 3)]);
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
