package ar.com.eduit.course.laboratories.laboratory4;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*

EnviarDeMensajes
Esta clase va a ser un thread o runnable y se instanciará y arrancará al momento de hacer click en el botón “enviar”.
Su responsabilidad será:
leer los datos de pantalla (host destino, puerto destino y mensaje)
abrir una conexión por socket tcp al destino
enviar el mensaje
cerrar el socket
Muy similar a lo que hacía nuestro Cliente TCP
*/
public class MessageSender extends Thread{
    private final Socket socket;
    private final String message;
    private final String host;
    private final int port;
    
    public MessageSender(String host, int port, String message) throws IOException{
        this.message = message;
        this.host = host;
        this.port = port;
        this.socket = new Socket(host, port);
    }

    @Override
    public void run() {
        try(OutputStream os = socket.getOutputStream()){
            for (char c : message.toCharArray()) {
                os.write(c);
            }
            socket.close();
        } catch (IOException ex) {
            
        }
    }    
}