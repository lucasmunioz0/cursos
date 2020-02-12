package ar.com.eduit.course.laboratories.laboratory5;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;
import java.util.Properties;

public class BroadcastContact extends Thread{
    
    private String args;

    public BroadcastContact(String args) {
        this.args = args;
    }
    
    @Override
    public void run(){
        try {
            Properties propiedades = LeerPropiedades(args);
            
            byte[] b = new byte[1];
            b[0] = 'a';
            
            DatagramPacket dgram = new DatagramPacket(b, b.length,
                    InetAddress.getByName(propiedades.getProperty("ipmulticast")),
                    Integer.parseInt(propiedades.getProperty("puertomulticast", "4000")));

            DatagramSocket socket = new DatagramSocket();
            while (true) {
                System.out.println("i'm alive at " + (new Date()));
                socket.send(dgram);
                Thread.sleep(2000);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Properties LeerPropiedades(String rutapropiedades) {
        InputStream inputfile = null;
        Properties prop = new Properties();
        try {

            inputfile = new FileInputStream(rutapropiedades);
            prop.load(inputfile);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return prop;
    }
}