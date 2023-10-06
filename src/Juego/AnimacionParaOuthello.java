package Juego;

import java.util.logging.Level;
import java.util.logging.Logger;
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
public class AnimacionParaOuthello extends Thread {

    private int mov = 0;
    private boolean estado;
    private JLabel lbl;

    public boolean isEstado() {
        return estado;
    }

    public AnimacionParaOuthello(JLabel lbl) {
        this.estado = false;
        this.lbl = lbl;

    }

    public void iniciarAnimacion() {
        this.estado = true;
    }

    public void animacionOn() {
        while (estado) {
            try {
                Thread.sleep(100);

                this.mov++;
                lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icono/" + mov + ".png")));
                if (mov == 6) {
                    mov = 0;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Tiempo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void reinciarAnimacion() {
        this.estado = true;
        lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icono/1.png")));;
    }

    public void animacionOf(boolean estado) {
        if (estado == false) {
            this.estado = false;
        }

    }

    public void run() {
        animacionOn();
    }
}
