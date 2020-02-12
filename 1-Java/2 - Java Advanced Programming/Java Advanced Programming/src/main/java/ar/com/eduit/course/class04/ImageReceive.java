package ar.com.eduit.course.class04;

/*
C:\\Users\\K53\\Documents\\CarreraJava\\Java Advanced Programming\\Java Advanced Programming\\src\\main\\java\\ar\\com\\eduit\\course\\class04\\
Siguiendo las caracteristicas del UDP, lo de "no asegura que llegue todo el mensaje", en este caso no perdemos información porque estamos en localhost y pruebas simples,
en una app real eso se refiere a que podríamos llegar a obtener la imagen pero "dañada" o incompleta?
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImageReceive {

    public static void main(String[] args) {
        try {
            Properties prop = readProperties(args[0]);
            byte[] b = new byte[21984];

            DatagramPacket dgram = new DatagramPacket(b, b.length);
            MulticastSocket socket = new MulticastSocket(4000);
            socket.joinGroup(InetAddress.getByName("235.1.1.1"));

            while (true) {
                String fileName = String.valueOf(new Date().getTime()) + ".jpg";
                socket.receive(dgram);
                FileOutputStream imageFile = 
                        new FileOutputStream("C:\\Users\\K53\\Documents\\CarreraJava\\Java Advanced Programming\\Java Advanced Programming\\src\\main\\java\\ar\\com\\eduit\\course\\class04\\" + fileName);
                imageFile.write(b);
                imageFile.close();
                System.out.println("File save sucessfuly");
            }
        } catch (Exception ex) {
        }
    }
    
    public static Properties readProperties(String pathProperties){
        InputStream inputFile = null;
        Properties prop = new Properties();
        try {
            inputFile = new FileInputStream(pathProperties);
            prop.load(inputFile);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        
        return prop;
    }
}
