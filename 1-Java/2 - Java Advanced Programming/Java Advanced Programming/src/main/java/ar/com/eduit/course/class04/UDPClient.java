/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.eduit.course.class04;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author K53
 */
public class UDPClient {
    public static void main(String[] args) {
        try {
            DatagramSocket socketClient = new DatagramSocket(4000, InetAddress.getByName("localhost"));
            DatagramPacket dataReceive = new DatagramPacket(new byte[200], 200);
            System.out.println("CLIENT: Ready to recive...");
            while(true){
                socketClient.receive(dataReceive);
                System.out.println("RECIVE: " + new String(dataReceive.getData()));
                String informationToSend = "Data receive " + (new Date());
                
                DatagramPacket dataToSend = new DatagramPacket(informationToSend.getBytes(), informationToSend.getBytes().length, InetAddress.getByName("localhost"), 5000);
                socketClient.send(dataToSend);
                
                Thread.sleep(2000L);
            }
        } catch (Exception ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
