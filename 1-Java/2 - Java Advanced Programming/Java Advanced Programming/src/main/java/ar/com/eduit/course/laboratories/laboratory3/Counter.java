package ar.com.eduit.course.laboratories.laboratory3;

import javax.swing.JTextField;

public class Counter extends Thread{
    private int counter;
    private JTextField txtCounter;

    public Counter(JTextField txtContador) {
        this.txtCounter = txtContador;
        this.counter = 1;
    }

    @Override
    public void run() {
        count();
    }    

    public synchronized void count(){
        while(true){
            counter += 1;
            txtCounter.setText(String.valueOf(counter));
        }
    }
    
    public synchronized void toWait(long l) throws InterruptedException{
        wait(l);
    }
}