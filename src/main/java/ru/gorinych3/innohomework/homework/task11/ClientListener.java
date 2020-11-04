package ru.gorinych3.innohomework.homework.task11;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;
import java.util.Objects;
import java.util.UUID;

public class ClientListener extends Thread {

    private static final Logger log = LogManager.getLogger(ClientListener.class.getName());
    private final String uuid;
    private String userName;
    private final Socket clientSocket;
    private final ChatServer chatServer;
    private BufferedReader reader;
    private BufferedWriter writer;

    public ClientListener(Socket clientSocket, ChatServer chatServer) {
        this.clientSocket = clientSocket;
        this.chatServer = chatServer;
        this.uuid = UUID.randomUUID().toString();
    }

    @Override
    public void run() {
        chatServer.addConnection(this);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getClientSocket().getInputStream()));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(getClientSocket().getOutputStream()))){

            setReader(bufferedReader);
            setWriter(bufferedWriter);
            userName = getMessage();
            String message = userName + " вошел в чат";
            chatServer.broadcastMessage(message, getUuid());

            while (true) {
                try {
                    message = getMessage();
                    if (message.startsWith("@")) {
                        chatServer.unicastMessage(userName + ": " + message, getUuid());
                    } else {
                        chatServer.broadcastMessage(userName + ": " + message, getUuid());
                    }
                } catch (IOException exception) {
                    message = userName + ": покинул чат";
                    chatServer.broadcastMessage(message, getUuid());
                    break;
                }
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } finally {
            chatServer.removeConnection(this);
            closeResources();
        }
    }

    private String getMessage() throws IOException {
        log.info("стартовал getMessage()");

        String message;
        do {
            message = reader.readLine();
        } while (reader.ready());
        return message;
    }

    public void closeResources() {
        log.info("Закрываем все подключения к пользователю");
        try {
            if (!Objects.equals(reader, null)) {
                reader.close();
            }
            if (!Objects.equals(writer, null)) {
                writer.close();
            }
        } catch (IOException e) {
            log.error("Ошибка при закрытии потоков в методе closeResources", e);
            e.printStackTrace();
        }

    }

    public String getUuid() {
        return uuid;
    }

    public BufferedWriter getWriter() {
        return writer;
    }

    public String getUserName() {
        return userName;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public void setWriter(BufferedWriter writer) {
        this.writer = writer;
    }
}
