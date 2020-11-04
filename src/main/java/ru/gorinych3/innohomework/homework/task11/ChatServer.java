package ru.gorinych3.innohomework.homework.task11;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {

    public static final Integer SERVER_PORT = 8090;
    private static final Logger log = LogManager.getLogger(ChatServer.class.getName());
    private final Set<ClientListener> clients = new HashSet<>();
    private ServerSocket serverSocket;

    public void listen() {
        try {
            serverSocket = new ServerSocket(SERVER_PORT);
            log.info("сервер запущен и ждет подключений");

            while (true) {
                Socket socket = serverSocket.accept();
                ExecutorService executorService = Executors.newCachedThreadPool();
                ClientListener clientListener = new ClientListener(socket, this);
                executorService.submit(clientListener);
            }
        } catch (IOException exception) {
            log.error("LOG: ошибка в методе listen()", exception);
            disconnect();
        }
    }

    public void addConnection(ClientListener clientListener) {
        log.info("run addConnection");
        clients.add(clientListener);
    }

    public void removeConnection(ClientListener clientListener) {
        log.info("run removeConnection");
        clients.remove(clientListener);
    }

    public void broadcastMessage(String message, String uuid) throws IOException {
        log.info("run broadcastMessage");
        BufferedWriter writer;
        for (ClientListener clientListener : clients) {
            if (!Objects.equals(clientListener.getUuid(), uuid)) {
                writer = clientListener.getWriter();
                writer.write(message);
                writer.newLine();
                writer.flush();
            }
        }
    }

    public void unicastMessage(String message, String uuid) throws IOException {
        log.info("run unicastMessage");
        BufferedWriter writer;
        String name = message.substring(message.indexOf("@") + 1, message.indexOf(","));
        message = message.replace("@" + name + ", ", "");
        for (ClientListener clientListener : clients) {
            if (Objects.equals(clientListener.getUserName(), name) && !Objects.equals(clientListener.getUuid(), uuid)) {
                writer = clientListener.getWriter();
                writer.write(message);
                writer.newLine();
                writer.flush();
            }
        }
    }

    public void disconnect() {
        try {
            serverSocket.close();
            for (ClientListener client : clients) {
                client.closeResources();
            }
        } catch (IOException e) {
            log.error("Ошибка при закрытии ресурсов", e);
        } finally {
            System.exit(0);
        }
    }
}
