/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import GUI.FrmGanador;
import GUI.FrmOTELO;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author Nebura
 */
public class Otello {

    private static ArrayList<Jugador> jg;
    private static Tablero tab;
    private static int turno;

    public Otello() {
        tab = new Tablero();
        jg = new ArrayList<>();
        turno = 0;
    }

    /**
     * The method adds two players , player one and player two.
     *
     * @param jg1 = player one
     * @param jg2 = player two
     */
    public static void añadir(Jugador jg1, Jugador jg2) {
        jg.add(jg1);
        jg.add(jg2);
        FrmOTELO.lblJugadores.setText(jg.get(turno).getNombre());
        FrmOTELO.lblcolor.setText(jg.get(turno).getColor());
        recorrerFichas();
    }

    public static Tablero getTab() {
        return tab;
    }

    /**
     * The method is simple and direct ,the method is reponsible for changing
     * the game pieces
     *
     * @param f=row
     * @param c =column
     */
    private static void cambiarDiagonalARI(int f, int c) {
        if (f >= 0 && c >= 0 && !(tab.getTablero()[f][c].getColor().equals(jg.get(turno).getColor()))) {
            tab.getTablero()[f][c].setColor(jg.get(turno).getColor());
            tab.getTablero()[f][c].setCambio(true);
            cambiarDiagonalARI((f - 1), (c - 1));
        }
    }

    /**
     * The method is simple and direct ,the method is reponsible for changing
     * the game pieces
     *
     * @param f=row
     * @param c =column
     */
    public static void cambiarDiagonalARD(int f, int c) {
        if (f < 12 && c >= 0 && !(tab.getTablero()[f][c].getColor().equals(jg.get(turno).getColor()))) {
            tab.getTablero()[f][c].setColor(jg.get(turno).getColor());
            tab.getTablero()[f][c].setCambio(true);
            cambiarDiagonalARD((f + 1), (c - 1));
        }
    }

    /**
     * The method is simple and direct ,the method is reponsible for changing
     * the game pieces
     *
     * @param f=row
     * @param c =column
     */
    public static void cambiarDiagonalABI(int f, int c) {
        if (f >= 0 && c < 12 && !(tab.getTablero()[f][c].getColor().equals(jg.get(turno).getColor()))) {
            tab.getTablero()[f][c].setColor(jg.get(turno).getColor());
            tab.getTablero()[f][c].setCambio(true);
            cambiarDiagonalABI((f - 1), (c + 1));
        }
    }

    /**
     * The method is simple and direct ,the method is reponsible for changing
     * the game pieces
     *
     * @param f=row
     * @param c =column
     */
    public static void cambiarDiagonalABD(int f, int c) {
        if (f < 12 && c < 12 && !(tab.getTablero()[f][c].getColor().equals(jg.get(turno).getColor()))) {
            tab.getTablero()[f][c].setColor(jg.get(turno).getColor());
            tab.getTablero()[f][c].setCambio(true);
            cambiarDiagonalABD((f + 1), (c + 1));
        }
    }

    /**
     * The method is simple and direct ,the method is reponsible for changing
     * the game pieces
     *
     * @param f=row
     * @param c =column
     */
    public static void cambiarDerecha(int f, int c) {
        if (f < 12 && !(tab.getTablero()[f][c].getColor().equals(jg.get(turno).getColor()))) {
            tab.getTablero()[f][c].setColor(jg.get(turno).getColor());
            tab.getTablero()[f][c].setCambio(true);
            cambiarDerecha((f + 1), c);
        }
    }

    /**
     * The method is simple and direct ,the method is reponsible for changing
     * the game pieces
     *
     * @param f=row
     * @param c =column
     */
    public static void cambiarIzquierda(int f, int c) {
        if (f >= 0 && !(tab.getTablero()[f][c].getColor().equals(jg.get(turno).getColor()))) {
            tab.getTablero()[f][c].setColor(jg.get(turno).getColor());
            tab.getTablero()[f][c].setCambio(true);
            cambiarIzquierda((f - 1), c);
        }
    }

    /**
     * The method is simple and direct ,the method is reponsible for changing
     * the game pieces
     *
     * @param f=row
     * @param c =column
     */
    public static void cambiarArriba(int f, int c) {
        try {
            if (c > -1 && !(tab.getTablero()[f][c].getColor().equals(jg.get(turno).getColor()))) {
                tab.getTablero()[f][c].setColor(jg.get(turno).getColor());
                tab.getTablero()[f][c].setCambio(true);
                cambiarArriba(f, (c - 1));
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }

    }

    /**
     * The method is simple and direct ,the method is reponsible for changing
     * the game pieces
     *
     * @param f=row
     * @param c =column
     */
    public static void cambiarAbajo(int f, int c) {
        if (c < 12 && !(tab.getTablero()[f][c].getColor().equals(jg.get(turno).getColor()))) {
            tab.getTablero()[f][c].setColor(jg.get(turno).getColor());
            tab.getTablero()[f][c].setCambio(true);
            cambiarAbajo(f, (c + 1));
        }
    }

    /**
     * It is an encapsulated method that calls to the posibilities that there
     * may be that there is a file.
     *
     * @param f
     * @param c
     */
    public static void verificaciones(int f, int c) {
        tab.getTablero()[f][c].setColor(jg.get(turno).getColor());
        if (posiblidadDerecha(f, c)) {
            cambiarDerecha((f + 1), c);
        }
        if (posiblidadIzquierda(f, c)) {
            cambiarIzquierda((f - 1), c);
        }
        if (posiblidadArriba(f, c)) {
            cambiarArriba(f, (c - 1));
        }
        if ((posiblidadAbajo(f, c))) {
            cambiarAbajo(f, (c + 1));
        }
        verificacionesDiagonales(f, c);
    }

    /**
     * It is an encapsulated method of diagonals that verifies the posibilities
     * of having a file.
     *
     * @param f=row
     * @param c =column
     */
    private static void verificacionesDiagonales(int f, int c) {
        if (posiblidadDiagonalABD(f, c)) {
            cambiarDiagonalABD((f + 1), (c + 1));
        }
        if (posiblidadDiagonalABI(f, c)) {
            cambiarDiagonalABI((f - 1), (c + 1));
        }
        if (posiblidadDiagonalARD(f, c)) {
            cambiarDiagonalARD((f + 1), (c - 1));
        }
        if (posiblidadDiagonalARI(f, c)) {
            cambiarDiagonalARI((f - 1), (c - 1));
        }
        cambiarTurno();
    }

    /**
     * The method is responsible for changing the player's turn.
     */
    private static void cambiarTurno() {
        if (turno == 0) {
            turno = 1;
        } else {
            turno = 0;
        }
        contarPuntos();
        FrmOTELO.lblJugadores.setText(jg.get(turno).getNombre());
        FrmOTELO.lblcolor.setText(jg.get(turno).getColor());
        esconderJugada();
        recorrerFichas();
        if (!(analizarBtns())) {
            ganarPorFaltaDeEspacio();
        }
    }

    /**
     * The method is resposible for desactivate the buttons.
     */
    private static void esconderJugada() {
        for (int f = 0; f < 12; f++) {
            for (int c = 0; c < 12; c++) {
                if (tab.getTablero()[f][c].getColor().equals("Neutral")) {
                    tab.getTablero()[f][c].getBtn().setVisible(false);
                }
            }
        }
    }

    /**
     * The method is responsible for count the points of the players.
     */
    private static void contarPuntos() {
        int p1 = 0, p2 = 0, n = 0;
        for (int f = 0; f < 12; f++) {
            for (int c = 0; c < 12; c++) {
                if (tab.getTablero()[f][c].getColor().equals("Negro")) {
                    p1++;
                } else if (tab.getTablero()[f][c].getColor().equals("Blanco")) {
                    p2++;
                }
                if (tab.getTablero()[f][c].getColor().equals("Neutral")) {
                    n++;
                }
            }
        }
        if (jg.get(0).getColor().equals("Negro")) {
            jg.get(0).setPuntacion(p1);
            jg.get(1).setPuntacion(p2);
        } else {
            jg.get(0).setPuntacion(p2);
            jg.get(1).setPuntacion(p1);
        }

        if (n == 0) {
            ganarPorFaltaDeEspacio();
        }

    }

    private static boolean analizarBtns() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                if ((tab.getTablero()[i][j].getBtn().isVisible())) {
                    return true;
                }
            }
        }
        return false;
    }
    /**Method is responsible when theren't anymore files to chanches
     * The 
     */
    private static void ganarPorFaltaDeEspacio() {
        FrmGanador ganador = new FrmGanador();
        if (jg.get(0).getPuntacion() > jg.get(1).getPuntacion()) {
            FrmGanador.lblGanador.setText(jg.get(0).getNombre());
            ganador.setVisible(true);
        } else {
            FrmGanador.lblGanador.setText(jg.get(1).getNombre());
            ganador.setVisible(true);
        }
    }

    /**
     * The method is responsible for verifiying the posibilities of play in that
     * direction
     *
     * @param f=row
     * @param c=column
     * @return false
     */
    private static boolean posiblidadDiagonalARI(int f, int c) {
        try {
            if (((tab.getTablero()[f - 1][c - 1].getColor().equals(jg.get(turno).getColor())))
                    || (tab.getTablero()[f - 1][c - 1].getColor().equals("Neutral"))) {
                return false;
            } else {
                return buscarDARIZ(f, c);
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        return false;
    }

    /**
     * The method is responsible for verifiying the posibilities of play in that
     * direction
     *
     * @param f=row
     * @param c=column
     * @return false
     */
    private static boolean posiblidadDiagonalARD(int f, int c) {
        try {
            if (((tab.getTablero()[f + 1][c - 1].getColor().equals(jg.get(turno).getColor())))
                    || (tab.getTablero()[f + 1][c - 1].getColor().equals("Neutral"))) {
                return false;
            } else {
                return buscarDARDE(f, c);
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        return false;
    }

    /**
     * The method is responsible for verifiying the posibilities of play in that
     * direction
     *
     * @param f=row
     * @param c=column
     * @return false
     */
    private static boolean posiblidadDiagonalABI(int f, int c) {
        try {
            if (((tab.getTablero()[f - 1][c + 1].getColor().equals(jg.get(turno).getColor())))
                    || (tab.getTablero()[f - 1][c + 1].getColor().equals("Neutral"))) {
                return false;
            } else {
                return buscarDABIZ(f, c);
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        return false;
    }

    /**
     * The method is responsible for verifiying the posibilities of play in that
     * direction
     *
     * @param f=row
     * @param c=column
     * @return false
     */
    private static boolean posiblidadDiagonalABD(int f, int c) {
        try {
            if (((tab.getTablero()[f + 1][c + 1].getColor().equals(jg.get(turno).getColor())))
                    || (tab.getTablero()[f + 1][c + 1].getColor().equals("Neutral"))) {
                return false;
            } else {
                return buscarDABDE(f, c);
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        return false;
    }

    /**
     * The method is responsible for verifiying the posibilities of play in that
     * direction
     *
     * @param f=row
     * @param c=column
     * @return false
     */
    private static boolean posiblidadDerecha(int f, int c) {
        try {
            if (((tab.getTablero()[f + 1][c].getColor().equals(jg.get(turno).getColor())))
                    || (tab.getTablero()[f + 1][c].getColor().equals("Neutral"))) {
                return false;
            } else {
                return buscarDerecha(f, c);
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        return false;
    }

    /**
     * The method is responsible for verifiying the posibilities of play in that
     * direction
     *
     * @param f=row
     * @param c=column
     * @return false
     */
    private static boolean posiblidadIzquierda(int f, int c) {
        try {
            if (((tab.getTablero()[f - 1][c].getColor().equals(jg.get(turno).getColor())))
                    || (tab.getTablero()[f - 1][c].getColor().equals("Neutral"))) {
                return false;
            } else {
                return buscarIzquierda(f, c);
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        return false;
    }

    /**
     * The method is responsible for verifiying the posibilities of play in that
     * direction
     *
     * @param f=row
     * @param c=column
     * @return false
     */
    private static boolean posiblidadArriba(int f, int c) {
        try {
            if (((tab.getTablero()[f][c - 1].getColor().equals(jg.get(turno).getColor())))
                    || (tab.getTablero()[f][c - 1].getColor().equals("Neutral"))) {
                return false;
            } else {
                return buscarArriba(f, c);
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        return false;
    }

    /**
     * The method is responsible for verifiying the posibilities of play in that
     * direction
     *
     * @param f=row
     * @param c=column
     * @return false
     */
    private static boolean posiblidadAbajo(int f, int c) {
        try {
            if (((tab.getTablero()[f][c + 1].getColor().equals(jg.get(turno).getColor())))
                    || (tab.getTablero()[f][c + 1].getColor().equals("Neutral"))) {
                return false;
            } else {
                return buscarAbajo(f, c);
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        return false;
    }

    /**
     * the method verify that there is a tile of the same color above
     *
     * @param f=row
     * @param c= column
     * @return false
     */
    private static boolean buscarAbajo(int f, int c) {
        try {
            if (tab.getTablero()[f][c + 1].getColor().equals("Neutral")) {
                return false;
            }
            if (!(tab.getTablero()[f][c].getColor().equals(jg.get(turno).getColor()))) {
                if ((tab.getTablero()[f][c + 1].getColor().equals(jg.get(turno).getColor()))) {
                    return true;
                } else {
                    return buscarAbajo(f, (c + 1));
                }
            } else {
                return buscarAbajo(f, (c + 1));
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        return false;
    }

    /**
     * the method verify that there is a tile of the same color above
     *
     * @param f=row
     * @param c= column
     * @return false
     */
    private static boolean buscarArriba(int f, int c) {
        try {
            if (tab.getTablero()[f][c - 1].getColor().equals("Neutral")) {
                return false;
            }
            if (!(tab.getTablero()[f][c].getColor().equals(jg.get(turno).getColor()))) {
                if ((tab.getTablero()[f][c - 1].getColor().equals(jg.get(turno).getColor()))) {
                    return true;
                } else {
                    return buscarArriba(f, (c - 1));
                }
            } else {
                return buscarArriba(f, (c - 1));
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        return false;
    }

    /**
     * the method verify that there is a tile of the same color above
     *
     * @param f=row
     * @param c= column
     * @return false
     */
    private static boolean buscarDerecha(int f, int c) {
        try {
            if (tab.getTablero()[f + 1][c].getColor().equals("Neutral")) {
                return false;
            }
            if (!(tab.getTablero()[f][c].getColor().equals(jg.get(turno).getColor()))) {
                if ((tab.getTablero()[f + 1][c].getColor().equals(jg.get(turno).getColor()))) {
                    return true;
                } else {
                    return buscarDerecha((f + 1), (c));
                }
            } else {
                return buscarDerecha((f + 1), (c));
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        return false;
    }

    /**
     * the method verify that there is a tile of the same color above
     *
     * @param f=row
     * @param c= column
     * @return false
     */
    private static boolean buscarIzquierda(int f, int c) {
        try {
            if (tab.getTablero()[f - 1][c].getColor().equals("Neutral")) {
                return false;
            }
            if (!(tab.getTablero()[f][c].getColor().equals(jg.get(turno).getColor()))) {
                if ((tab.getTablero()[f - 1][c].getColor().equals(jg.get(turno).getColor()))) {
                    return true;
                } else {
                    return buscarIzquierda((f - 1), c);
                }
            } else {
                return buscarIzquierda((f - 1), c);
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        return false;
    }

    /**
     * the method verify that there is a tile of the same color above
     *
     * @param f=row
     * @param c= column
     * @return false
     */
    private static boolean buscarDARIZ(int f, int c) {
        try {
            if (tab.getTablero()[f - 1][c - 1].getColor().equals("Neutral")) {
                return false;
            }
            if (!(tab.getTablero()[f][c].getColor().equals(jg.get(turno).getColor()))) {
                if ((tab.getTablero()[f - 1][c - 1].getColor().equals(jg.get(turno).getColor()))) {
                    return true;
                } else {
                    return buscarDARIZ((f - 1), (c - 1));
                }
            } else {
                return buscarDARIZ((f - 1), (c - 1));
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        return false;
    }

    /**
     * the method verify that there is a tile of the same color above
     *
     * @param f=row
     * @param c= column
     * @return false
     */
    private static boolean buscarDARDE(int f, int c) {
        try {
            if (tab.getTablero()[f + 1][c - 1].getColor().equals("Neutral")) {
                return false;
            }
            if (!(tab.getTablero()[f][c].getColor().equals(jg.get(turno).getColor()))) {
                if ((tab.getTablero()[f + 1][c - 1].getColor().equals(jg.get(turno).getColor()))) {
                    return true;
                } else {
                    return buscarDARDE((f + 1), (c - 1));
                }
            } else {
                return buscarDARDE((f + 1), (c - 1));
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        return false;
    }

    /**
     * the method verify that there is a tile of the same color above
     *
     * @param f=row
     * @param c= column
     * @return false
     */
    private static boolean buscarDABIZ(int f, int c) {
        try {
            if (tab.getTablero()[f - 1][c + 1].getColor().equals("Neutral")) {
                return false;
            }
            if (!(tab.getTablero()[f][c].getColor().equals(jg.get(turno).getColor()))) {
                if ((tab.getTablero()[f - 1][c + 1].getColor().equals(jg.get(turno).getColor()))) {
                    return true;
                } else {
                    return buscarDABIZ((f - 1), (c + 1));
                }
            } else {
                return buscarDABIZ((f - 1), (c + 1));
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        return false;
    }

    /**
     * the method verify that there is a tile of the same color above
     *
     * @param f=row
     * @param c= column
     * @return false
     */
    private static boolean buscarDABDE(int f, int c) {
        try {
            if (tab.getTablero()[f + 1][c + 1].getColor().equals("Neutral")) {
                return false;
            }
            if (!(tab.getTablero()[f][c].getColor().equals(jg.get(turno).getColor()))) {
                if ((tab.getTablero()[f + 1][c + 1].getColor().equals(jg.get(turno).getColor()))) {
                    return true;
                } else {
                    return buscarDABDE((f + 1), (c + 1));
                }
            } else {
                return buscarDABDE((f + 1), (c + 1));
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        return false;
    }

    /**
     * The method roam the board looking for othello files that the color is
     * equal to neutral
     */
    private static void recorrerFichas() {
        for (int f = 0; f < 12; f++) {
            for (int c = 0; c < 12; c++) {
                if (tab.getTablero()[f][c].getColor().equals("Neutral")) {
                    activarFichas(f, c);
                }
            }
        }
    }

    /**
     * The method is responsible for activating the othello files
     *
     * @param f=row
     * @param c=column
     */
    private static void activarFichas(int f, int c) {
        boolean bandera = false;
        if ((posiblidadAbajo(f, c))) {
            bandera = true;
        }
        if ((posiblidadArriba(f, c)) && !(bandera)) {
            bandera = true;
        }
        if ((posiblidadDerecha(f, c)) && !(bandera)) {
            bandera = true;
        }
        if ((posiblidadIzquierda(f, c)) && !(bandera)) {
            bandera = true;
        }
        if ((posiblidadDiagonalARI(f, c)) && !(bandera)) {
            bandera = true;
        }
        if ((posiblidadDiagonalARD(f, c)) && !(bandera)) {
            bandera = true;
        }
        if ((posiblidadDiagonalABI(f, c)) && !(bandera)) {
            bandera = true;
        }
        if ((posiblidadDiagonalABD(f, c) && !(bandera))) {
            bandera = true;
        }
        if ((bandera)) {
            tab.getTablero()[f][c].getBtn().setVisible(true);
        }
    }
}
