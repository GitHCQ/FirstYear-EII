package uo.mp.lab01.game.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import uo.mp.lab01.game.model.util.ForTesting;

public class Game2048RestartTest {
	/*
	 * Casos del metodo restar:
	 * -Caso1:El tablero está vacio, se reinicia y se añade un 2.
	 * -Caso2.El tablero está semilleno, se reinicia y añade un 2.
	 * -Caso3.El tablero ya está vacio, se añade un 2.
	 */
	//Metodo auxiliar que comprueba si hay un dos en la matriz
	
	/**
	 * Caso1:Se pone todos los elementos del tablero a 0 y se llama al metodo next
	 */
	@Test
	public void restartFull() {
		Game2048 game=new Game2048(ForTesting.EMPTY);
		int suma_inicial=ForTesting.getSum(game.getBoard());
		assertEquals(suma_inicial,ForTesting.getSum(game.getBoard()));
		game.restart();
		assertEquals(2,ForTesting.getSum(game.getBoard()));
	}
	/**
	 * Caso2:Se pone todos los elementos del tablero a 0 y se llama al metodo next
	 */
	@Test
	public void restartSemiFull() {
		Game2048 game=new Game2048(ForTesting.SEMIFULL31);
		int suma_inicial=ForTesting.getSum(game.getBoard());
		assertEquals(suma_inicial,ForTesting.getSum(game.getBoard()));
		game.restart();
		assertEquals(2,ForTesting.getSum(game.getBoard()));
	}
	/**
	 * Caso3:El tablero está lleno.
	 */
	@Test
	public void restartEmpty() {
		Game2048 game=new Game2048(ForTesting.FULL);
		int suma_inicial=ForTesting.getSum(game.getBoard());
		assertEquals(suma_inicial,ForTesting.getSum(game.getBoard()));
		game.restart();
		assertEquals(2,ForTesting.getSum(game.getBoard()));
	}

}
