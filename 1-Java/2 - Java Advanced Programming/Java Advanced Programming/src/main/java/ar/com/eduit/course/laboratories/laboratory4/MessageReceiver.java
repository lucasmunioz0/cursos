package ar.com.eduit.course.laboratories.laboratory4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MessageReceiver implements Runnable {

    private final int port;
    private final IChat chat;

    public MessageReceiver(int port, IChat chat) throws IOException {
        this.port = port;
        this.chat = chat;
    }

    @Override
    public void run() {
        try {
            final ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = null;
            MessageManager manager = null;
            while (true) {
                socket = serverSocket.accept();
                chat.setInfoMessage("New connection from: " + socket.getInetAddress());
                manager = new MessageManager(socket, chat);
                new Thread(manager).start();
            }
        } catch (IOException ex) {
            chat.setErrorMessage(ex.getMessage());
        }
    }
}