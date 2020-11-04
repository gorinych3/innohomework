package ru.gorinych3.innohomework.homework.task11;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;

public class MessagesReader implements Runnable {

    private static final Logger log = LogManager.getLogger(MessagesReader.class.getName());
    private final BufferedReader reader;

    public MessagesReader(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public void run() {
        String inputMessage;
        while (true) {
            try {
                do {
                    inputMessage = reader.readLine();
                } while (reader.ready());
                System.out.println(inputMessage);
            } catch (IOException e) {
                System.out.println("Подключение было прервано");
                log.error("Ошибка подключения: " + e.getMessage());
                System.exit(0);
            }
        }
    }
}
