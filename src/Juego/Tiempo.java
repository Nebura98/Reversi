package Juego;



import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kille
 */
public class Tiempo extends Thread{
    public boolean estado;
    public int mili=0,sec=0,min=0;
    public JButton btn;
    public JButton btn2;   
    public int getMili() {
        return mili;
    }

    public int getSec() {
        return sec;
    }

    public int getMin() {
        return min;
    }
    
    

    public boolean isEstado() {
        return estado;
    }

    public Tiempo(JButton btn,JButton btn2) {
        this.estado = false;
        this.btn = btn;
        this.btn2=btn2;
        
        this.procesos();
    }
    
    public void procesos(){
        this.iniciar();
        this.esperar();
        this.reiniciar();
 
        
    }
    
    public void iniciar(){
        this.estado=true;
        btn.setForeground(Color.black);
     
    }
    
    public void esperar(){
        this.estado=false;
       
       
    }
    
    public void reiniciar(){
        this.estado=true;
        btn.setForeground(Color.black);
        
        this.mili=0;
        this.sec=0;
        this.min=0;
        
        
    }
    
       public void cronometrar(){
     for (;;) {
            if (estado==true) {
                try {
                    Thread.sleep(1);
                    if (this.mili>=1000) {
                        this.mili=0;
                        this.sec++;
                    }
                    if (this.sec>=60) {
                        this.mili=0;
                        this.sec=0;
                        this.min++;
                    }
                    
                    if (this.min<10) {
                        btn.setText("0"+this.min);
                    }else{
                    btn.setText(String.valueOf(this.min));
                    }
                       if (sec<10) {
                        btn2.setText("0"+this.sec);
                    }else{
                            btn2.setText(String.valueOf(this.sec));
                       }
                  
                      mili++;
                } catch (InterruptedException e) {
                    
                }
                        }else{
            break;
            }
            }
        
       }
                 
    @Override
    public void run() {
        this.cronometrar();
    }
    
}
