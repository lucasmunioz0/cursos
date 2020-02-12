 /*
  * To change this license header, choose License Headers in Project Properties.
  * To change this template file, choose Tools | Templates
  * and open the template in the editor.
  */
 
 package ar.com.eduit.course.class01;
 
 import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
 import java.time.LocalTime;
 import javax.swing.JTextField;
 
 
 public class HourR implements Runnable{
     private JTextField txtHora;
     private JTextField txtHora2;
 
     public HourR(JTextField txtHora,JTextField txtHora2) {
        this.txtHora = txtHora;
        this.txtHora2 = txtHora2;
    }

    @Override
    public void run() {
        while(true){
            try{
                DecimalFormat df = new DecimalFormat("00");
                LocalTime lt = LocalTime.now();
                txtHora.setText(df.format(lt.getHour()) + ":" + 
                                df.format(lt.getMinute()) + ":" + 
                                df.format(lt.getSecond()));
                
                //txtHora2.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format());
                Thread.sleep(1000);                
            }catch(InterruptedException e){}            
        }        
    }
}