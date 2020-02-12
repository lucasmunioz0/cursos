/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.eduit.course.class01;

import java.text.DecimalFormat;
import javax.swing.JTextField;


public class CronometerR implements Runnable{
    private JTextField txt;
    private int cont = 0;
    private boolean correr = false;

    public CronometerR(JTextField txt) {
        this.txt = txt;
    }    
    
    @Override
    public void run() {
        while(true){
            if(correr){
                cont++;
                txt.setText(new DecimalFormat("000000").format(cont));
            }
            try{ Thread.sleep(1000); }catch(InterruptedException e){}
        }
    }
    
    public void start(){
        correr = true;
    }
    
    public void stop(){
        correr = false;
        cont = 0;
        txt.setText("000000");
    }
    
    public void pause(){
        correr = false;
    }
}