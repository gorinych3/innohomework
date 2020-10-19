package ru.gorinych3.innohomework.homework.task7.part3;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ChangeEncoding {

    private ChangeEncoding() {
    }

    public static void utf8ToUtf16(String inFileName, String outFileName) {

        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(inFileName), StandardCharsets.UTF_8);
             OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(outFileName), StandardCharsets.UTF_16)) {

            while (isr.ready()) {
                osw.write(isr.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
