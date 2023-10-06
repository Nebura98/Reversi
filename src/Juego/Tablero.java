/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import javax.swing.JButton;

/**
 *
 * @author Nebura
 */
public class Tablero {

    private Ficha[][] tablero;
    private JButton btn;

    public Ficha[][] getTablero() {
        return tablero;
    }

    public void setTablero(Ficha[][] tablero) {
        this.tablero = tablero;
    }

    public Tablero() {
        this.tablero = new Ficha[12][12];
        llenarMatriz();
        desactivarBtn();
        desaparecerFichas();
    }
/**
 * this method is responsible full the matrix with files
 */
    
    private void llenarMatriz() {
        for (int f = 0; f < 12; f++) {
            for (int c = 0; c < 12; c++) {
                this.tablero[f][c] = new Ficha(f, c);
            }
        }
    }
/**
 * this method is responsible that invisible the files
 */
    private void desaparecerFichas() {
        for (int f = 0; f < 12; f++) {
            for (int c = 0; c < 12; c++) {
                if (this.tablero[f][c].getColor().equals("Neutral")) {
                    this.tablero[f][c].getBtn().setVisible(false);
                }
            }
        }
    }

    private void desactivarBtn() {
        this.tablero[5][5].setColor("Negro");
        this.tablero[5][6].setColor("Blanco");
        this.tablero[6][5].setColor("Blanco");
        this.tablero[6][6].setColor("Negro");
        this.tablero[5][5].getBtn().setContentAreaFilled(false);
        this.tablero[5][6].getBtn().setContentAreaFilled(false);
        this.tablero[6][5].getBtn().setContentAreaFilled(false);
        this.tablero[6][6].getBtn().setContentAreaFilled(false);
        this.tablero[5][5].getBtn().setEnabled(false);
        this.tablero[5][6].getBtn().setEnabled(false);
        this.tablero[6][5].getBtn().setEnabled(false);
        this.tablero[6][6].getBtn().setEnabled(false);
        this.tablero[5][5].getBtn().setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/icono/Blanco0.png")));
        this.tablero[5][6].getBtn().setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/icono/Negro0.png")));
        this.tablero[6][5].getBtn().setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/icono/Negro0.png")));
        this.tablero[6][6].getBtn().setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/icono/Blanco0.png")));
    }
}
