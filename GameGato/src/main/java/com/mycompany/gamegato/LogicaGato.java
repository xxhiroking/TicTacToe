/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gamegato;

/**
 *
 * @author Hiro
 */
public class LogicaGato {

    private final char[][] tablero = new char[3][3];
    public char jugadorActual = 'X';

    public void inicializarTablero() {
        int cont = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = (char) (cont + '0');
                cont++;
            }
        }
    }

    public void imprimirTablero() {
        System.out.println("_______");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + "|");
            }
            System.out.println();
            if (i < 2) {
                System.out.println("-------");
            }
        }
        System.out.println("_______");
    }

    public boolean validarMovimiento(int fila, int columna) {
        return fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna] != 'X' && tablero[fila][columna] != 'O';
    }

    public boolean hayGanador(char simbolo) {
        // Verificar filas, columnas y diagonales
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == simbolo && tablero[i][1]  == simbolo && tablero[i][2] == simbolo) {
                return true;
            }
            if (tablero[0][i] == simbolo && tablero[1][i] == simbolo && tablero[2][i] == simbolo) {
                return true;
            }
        }
        if (tablero[0][0] == simbolo && tablero[1][1] == simbolo && tablero[2][2] == simbolo) {
            return true;
        }
        if (tablero[0][2] == simbolo && tablero[1][1] == simbolo && tablero[2][0] == simbolo) {
            return true;
        }
        return false;
    }

    public boolean hayEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ('0' == tablero[i][j] || Character.isDigit(tablero[i][j])) {
                 return false;   
                }
            }
        }
        return true; // Si todas las casillas están ocupadas, hay empate
    }

    public void realizarMovimiento(int fila, int columna) {
        if (validarMovimiento(fila, columna)) {
            tablero[fila][columna] = jugadorActual;
            jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
        } else {
            System.out.println("Movimiento inválido. Intenta de nuevo.");
        }
    }

}
