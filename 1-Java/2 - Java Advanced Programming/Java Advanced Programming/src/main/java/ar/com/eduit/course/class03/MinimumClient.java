package ar.com.eduit.course.class03;

import java.net.*;
import java.io.*;

public class MinimumClient {

    public static void main(String args[]) throws IOException {
        int c;
        Socket socket = null;
        InputStream is;
        // Open a connection with breogan in the port 4321
        try {
            socket = new Socket("localhost", 4321);
        } catch (IOException e) {
            System.out.println(e);
        }
        // Obtains an input file controller asociate with the socket and read that input.
        is = socket.getInputStream();
        while ((c = is.read()) != -1) {
            System.out.print((char) c);
        }
        // When the end of the file is reached, we close the connection and finish.
        socket.close();
    }
}
