package uo.mp.lab02.game.model;

import static org.junit.Assert.*;


import org.junit.Test;

public class Game2048WithBoardParamTest {
	/*
	 * Casos de prueba del constructor con parametro tablero.
	 * -Casos negativos:
	 * 1.El tablero es null.
	 * 2.Tamaño del tablero fuera de los limites
	 * 3.El tablero no es cuadrado.
	 * 4.Los valores de la matriz no son potencia de 2.
	 * -Casos positivos:
	 * 5.Se introduce un tablero con valores potencia de 2 y dentro de los limites de tamaño.
	 */
	/**
	 * Caso 1.Tablero es null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void tableroNull() {
		int [][]nullBoard=null;
		Game2048 game=new Game2048(nullBoard);
	}
	/**
	 * Caso 2.Tablero fuera de los limites.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void tableroSizeOutLimits() {
		int [][]outLimits=new int [1][1];
		Game2048 game=new Game2048(outLimits);
	}
	/**
	 * Caso 3.Tablero no es cuadrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void tableroNotSquare() {
		int [][]notSquare=new int [4][3];
		Game2048 game=new Game2048(notSquare);
	}
	/**
	 * Caso 4.Los valores del tablero no son potencia de 2.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void tableroNotPowerOfTwo() {
		int[][] notPowerOfTwo = {
	            {3, 4, 8},
	            {16, 32, 64},
	            {128, 256, 512}};
		Game2048 game=new Game2048(notPowerOfTwo);
		}
	/**
	 * Caso 4.El tablero está perfectamente creado
	 */
	@Test
	public void tableroOk() {
		int[][] PowerOfTwo = {
	            {2, 4, 8},
	            {16, 32, 64},
	            {128, 256, 512}};
		Game2048 game=new Game2048(PowerOfTwo);
		assertArrayEquals(PowerOfTwo, game.getBoard());
		}
	}
	