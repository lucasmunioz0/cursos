package ar.com.eduit.course.class03;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientTCP {

    public static void main(String[] args) throws IOException {
        final String msg = "Information for server.";
        try (Socket socket = new Socket("192.168.0.107", 8080); InputStream inputStream = socket.getInputStream(); OutputStream os = socket.getOutputStream()) {
            System.out.println("Reading information...");
            int c;            
            while ((c = inputStream.read()) != -1) {
                System.out.print((char)c);
            }
            
            for (char d : msg.toCharArray()) {
                os.write(d);
            }
            
            System.out.println("\nEnd of reading...");
        }
    }
}