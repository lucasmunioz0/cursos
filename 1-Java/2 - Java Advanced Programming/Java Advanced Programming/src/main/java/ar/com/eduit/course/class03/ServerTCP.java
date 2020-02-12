package ar.com.eduit.course.class03;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {

    public static void main(String[] args) throws IOException, InterruptedException {
        final String inforCliente = "Information for client.";
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                System.out.println("Waiting for connection...");
                try (Socket socket = serverSocket.accept(); OutputStream os = socket.getOutputStream(); InputStream is = socket.getInputStream()) {
                    for (char c : inforCliente.toCharArray()) {
                        os.write(c);
                    }
                    
                    Thread.sleep(1000L);
                    int i;
                    while((i = is.read()) != -1){
                        System.out.print((char)i);
                    }
                }
            }
        }
    }
}