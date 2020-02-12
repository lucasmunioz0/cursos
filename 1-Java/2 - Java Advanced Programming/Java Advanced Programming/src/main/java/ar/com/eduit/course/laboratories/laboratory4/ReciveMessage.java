package ar.com.eduit.course.laboratories.laboratory4;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JTextArea;

public class ReciveMessage extends Thread {

    private int port;
    private JTextArea txtMessage;

    public ReciveMessage(int port) {
        this.port = port;
    }

    public ReciveMessage(int port, JTextArea txtMessage) {
        this.port = port;
        this.txtMessage = txtMessage;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public JTextArea getTxtMessage() {
        return txtMessage;
    }

    public void setTxtMessage(JTextArea txtMessage) {
        this.txtMessage = txtMessage;
    }
    //jose_alejandromm@hotmail.com
    @Override
    public void run() {
        try {
            System.out.println("Inicializating thread on port: " + port);
            ServerSocket serverSocket = new ServerSocket(port);
            Socket socket;
            while (true) {
                socket = serverSocket.accept();
                
                InputStream inputStream = socket.getInputStream();
                int c;
                StringBuilder sb = new StringBuilder();
                while((c = inputStream.read()) != -1){
                    sb.append((char)c);
                }
                
                txtMessage.setText(txtMessage.getText() + "\n" + sb.toString());
                
                socket.close();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
