package ru.gorinych3.innohomework.homework.task11;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class ChatClient1 {

    private static final Logger log = LogManager.getLogger(ChatClient1.class.getName());
    private static final String SERVER_HOST = "127.0.0.1";
    private static final Integer SERVER_PORT = 8090;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
             Scanner scanner = new Scanner(System.in);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String userName = scanner.nextLine();
            writer.write(userName);
            writer.newLine();
            writer.flush();

            Thread readMessages = new Thread(new MessagesReader(reader));
            readMessages.start();
            System.out.println("Добро пожаловать, " + userName);

            sendMessage(scanner, writer);

        } catch (IOException e) {
            System.out.println("сервер недоступен, попробуйте подключиться позже");
            log.error(e.getMessage());
        } finally {
            System.exit(0);
        }
    }

    public static void sendMessage(Scanner scanner, BufferedWriter writer) throws IOException {
        String outputMessage;
        while (true) {
            outputMessage = scanner.nextLine();
            if("quit".equals(outputMessage)){
                System.exit(0);
            }
            if(!Objects.equals(outputMessage, null)
                    && !outputMessage.isEmpty()
                    && !Objects.equals("\n", outputMessage)) {
                writer.write(outputMessage);
                writer.newLine();
                writer.flush();
            }
        }
    }
}
