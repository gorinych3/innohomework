package ru.gorinych3.innohomework.homework.task7.part2;

import java.io.*;

public class TextWriteImpl implements TextWrite {

    private ParagraphGenerate paragraphGenerate;

    private SentenceGenerate sentenceGenerate;

    private WordGenerate wordGenerate;


    @Override
    public void getFiles(String path, int n, int size, String[] arrWords, int probability) {
        wordGenerate = new WordGenerateImpl(arrWords);
        sentenceGenerate = new SentenceGenerateImpl(wordGenerate);
        paragraphGenerate = new ParagraphGenerateImpl(probability, sentenceGenerate);

        for (int i = 0; i < n; i++) {
            String text = paragraphGenerate.generateParagraph();
            File file = new File(path, "GenText" + i + ".txt");

            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)), size)) {
                bw.append(text);
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
