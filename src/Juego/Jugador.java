/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import javax.swing.JLabel;

/**
 *
 * @author Nebura
 */
public class Jugador {

    protected String nombre;
    private int puntacion;
    private String color;
    private JLabel lblpt;

    public void setLblpt(int puntos) {
        this.lblpt.setText(Integer.toString(puntos));
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPuntacion() {
        return puntacion;
    }

    public void setPuntacion(int puntacion) {
        this.puntacion = puntacion;
        setLblpt(puntacion);
    }
    
    public String getNombre(){
        return this.nombre;
    }

    public Jugador(String nombre, String color, JLabel pt) {
        this.nombre = nombre;
        this.puntacion = 0;
        this.color = color;
        this.lblpt= pt;
    }

}
