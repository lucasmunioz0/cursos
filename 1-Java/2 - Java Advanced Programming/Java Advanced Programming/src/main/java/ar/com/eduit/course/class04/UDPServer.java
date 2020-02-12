package ar.com.eduit.course.class04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class UDPServer {
    public static void main(String[] args) {
        try{
            DatagramSocket socketServer = new DatagramSocket(5000, InetAddress.getByName("localhost"));
            String sendInformation = "Information to Send from Server";
            DatagramPacket sendData = new DatagramPacket(sendInformation.getBytes(), sendInformation.getBytes().length, InetAddress.getByName("localhost"), 4000);
            
            while(true){
                sendInformation += " " + new Date().toString();
                socketServer.send(sendData);
                
                Thread.sleep(2000L);
                DatagramPacket dataToReceive = new DatagramPacket(new byte[200], 200);
                socketServer.receive(dataToReceive);
                System.out.println("RECEIVE FROM CLIENT: " + new String(dataToReceive.getData()));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
