package ar.com.eduit.course.laboratories.laboratory4;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class MessageManager implements Runnable{
    private IChat chat;
    private Socket socket;
    
    public MessageManager(Socket socket, IChat chat) {
        this.socket = socket;
        this.chat = chat;
    }

    @Override
    public void run() {
        try{
            try (InputStream is = socket.getInputStream()) {
                chat.setInfoMessage("Handling connection from: " + socket.getInetAddress());
                StringBuilder sb = new StringBuilder();
                int c;
                while((c = is.read()) != -1){
                    sb.append((char)c);
                }
                chat.setMessageSent(socket.getInetAddress() + ":" + socket.getPort() + " => " + sb.toString());
            }
            socket.close();
        } catch (IOException ex) {
            chat.setErrorMessage(ex.getMessage());
        }
    }   
}