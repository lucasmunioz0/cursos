package ar.com.eduit.course.class04;

import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.file.Files;
import java.util.Date;

public class ImageEmisor {
    public static void main(String[] args) {
        try {
            File image = new File("C:\\Users\\K53\\Documents\\CarreraJava\\Java Advanced Programming\\Java Advanced Programming\\src\\main\\java\\ar\\com\\eduit\\course\\class04\\image011.jpg");
            byte[] b = Files.readAllBytes(image.toPath());
            DatagramPacket dgram = new DatagramPacket(b, b.length, 
                    InetAddress.getByName("235.1.1.1"), 4000);
            //MulticastSocket socket = new MulticastSocket(4000);
            //socket.joinGroup(InetAddress.getByName("235.1.1.1"));
            
            System.out.println("Size of send: " + b.length);
            
            DatagramSocket socket = new DatagramSocket();
            System.out.println("HOLA!");
            while(true){
                System.out.println("Sending image..." + new Date());
                socket.send(dgram);
                Thread.sleep(4000L);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
