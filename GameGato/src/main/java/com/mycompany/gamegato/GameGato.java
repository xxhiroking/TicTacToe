/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.gamegato;

import java.util.Scanner;

/**
 *
 * @author Hiro
 */
public class GameGato {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        LogicaGato juego = new LogicaGato();
        juego.inicializarTablero();
        juego.imprimirTablero();

        Scanner scanner = new Scanner(System.in);
        while (!juego.hayEmpate() && !juego.hayGanador('X') && !juego.hayGanador('O')) {
            System.out.print("Jugador " + juego.jugadorActual + ", ingresa el número de casilla (1-9): ");
            int casilla = scanner.nextInt() - 1;
            int fila = casilla / 3;
            int columna = casilla % 3;

            juego.realizarMovimiento(fila, columna);
            juego.imprimirTablero();
        }
        if (juego.hayGanador('X')) {
            System.out.println("¡El jugador X ha ganado!");
        } 
        else if (juego.hayGanador('O')) {
            System.out.println("El jugador 0 ha ganado");
        }
        else if (juego.hayEmpate()){
            System.out.println("¡Empate!");
        }

    }
}
