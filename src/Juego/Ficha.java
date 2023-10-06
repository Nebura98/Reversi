
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import Juego.Otello;
import javax.swing.JLabel;

/**
 *
 * @author Nebura
 */
public class Ficha {

    private JLabel lblFicha;
    private JButton btn;
    private String color;
    private int columna;
    private int fila;
    private boolean cambio;

    public boolean isCambio() {
        return cambio;
    }

    public void setCambio(boolean cambio) {
        this.cambio = cambio;
    }

    public JButton getBtn() {
        return btn;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getColumna() {
        return columna;
    }

    public int getFila() {
        return fila;
    }

    public JLabel getLblFicha() {
        return lblFicha;
    }

    public void setLblFicha(JLabel lblFicha) {
        this.lblFicha = lblFicha;
    }

    public Ficha(int fila, int columna) {
        this.btn = new JButton();
        this.lblFicha = new JLabel();
        this.color = "Neutral";
        this.fila = fila;
        this.columna = columna;
        this.cambio = false;
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarInfo();
            }
        });

    }

    /**
     * This method throw the file infomation
     */
    private void enviarInfo() {
        btn.setContentAreaFilled(false);
        this.cambio = true;
        Otello.verificaciones(fila, columna);
    }

}
