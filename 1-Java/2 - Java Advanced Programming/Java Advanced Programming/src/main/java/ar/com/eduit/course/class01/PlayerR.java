/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.eduit.course.class01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class PlayerR implements Runnable{

    @Override
    public void run() {
        try{
            new Player(new FileInputStream(new File("res/IntroGlobalMentoring.mp3"))).play();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (JavaLayerException ex) {
            Logger.getLogger(PlayerR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
