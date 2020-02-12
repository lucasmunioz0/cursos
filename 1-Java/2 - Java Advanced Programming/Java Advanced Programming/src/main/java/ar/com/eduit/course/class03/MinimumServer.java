package ar.com.eduit.course.class03;

import java.net.*;
import java.io.*;

public class MinimumServer {

    public static void main(String args[]) {
        ServerSocket serverSocket = (ServerSocket) null;
        Socket socket;
        String chain = "Java Tutorial!";
        int longChain;
        OutputStream os;
        // Establish the server in the socket 4321 (wait 300 seconds)
        try {
            serverSocket = new ServerSocket(4321, 300);
        } catch (IOException e) {
            System.out.println(e);
        }
        // Execute an infinite loop of listen/accept
        while (true) {
            try {
        // Wait for the connection
                socket = serverSocket.accept();
        // Obtains an output file controller asociate with the socket
                os = socket.getOutputStream();
        // Send out message
                longChain = chain.length();
                for (int i = 0; i < longChain; i++) {
                    os.write((int) chain.charAt(i));
                }
        // Close the connection, but not the server socket
                socket.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
