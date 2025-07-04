package uo.mp.lab01.game.model;

import static org.junit.Assert.assertArrayEquals;


import org.junit.Test;

import uo.mp.lab01.game.model.util.ForTesting;

public class Game2048CompactRightTest {

	/*
	 * Casos de uso
	 * 1. Matriz con un valor por fila en columna 0
	 * 2- Matriz con un valor por fila en columna 1
	 * 3- Matriz con un valor por fila en columna 2
	 * 
	 * 4- Matriz con 2 valores por fila (en 1 y 2)
	 * 5- Matriz con 2 valores por fila (en 0 y 1)
	 * 6- Matriz con 2 valores por fila (en 1 y 3)
	 * 
	 * 7- Matriz con 3 valores por fila 
	 * 
	 */
	
	/**
	 * Casos de uso
	 * 1. Matriz con un valor por fila en columna 0
	 */
	@Test
	public void OneValueForRowInColumn0() {
		//		public static int[][] SEMIFULL12 = {{2,0,0},
		//                							{2,0,0},
		//                							{2,0,0}};
		Game2048 game = new Game2048(ForTesting.SEMIFULL12);
		game.compactRight();
		assertArrayEquals(ForTesting.SEMIFULL1_RIGHTCOMPACTED, game.getBoard());
	}
	
	/**
	 * Casos de uso
	 * 2- Matriz con un valor por fila en columna 1
	 */
	@Test
	public void oneValueForRowInColumn1() {
		//		public static int[][] SEMIFULL11 = {{0,2,0},
		//											{0,2,0},
		//											{0,2,0}};
		Game2048 game = new Game2048(ForTesting.SEMIFULL11);
		game.compactRight();
		assertArrayEquals(ForTesting.SEMIFULL1_RIGHTCOMPACTED, game.getBoard());
	}
	
	/**
	 * Casos de uso
	 * 3- Matriz con un valor por fila en columna 2
	 */
	@Test
	public void oneValueForRowInColumn2() {
		//		public static int[][] SEMIFULL13 = {{0,0,2},
		//											{0,0,2},
		//											{0,0,2}};
		Game2048 game = new Game2048(ForTesting.SEMIFULL13);
		game.compactRight();
		assertArrayEquals(ForTesting.SEMIFULL1_RIGHTCOMPACTED, game.getBoard());
	}
	
	/**
	 * Casos de uso
	 * 4- Matriz con 2 valores por fila (en 1 y 2)
	 *
	 */
	@Test
	public void twoValuesForRowInColumn1And2() {
	//		public static int[][] SEMIFULL21 = {{0,2,2},
	//											{0,2,2},
	//											{0,2,2}};
		Game2048 game = new Game2048(ForTesting.SEMIFULL21);
		game.compactRight();
		assertArrayEquals(ForTesting.SEMIFULL2_RIGHTCOMPACTED, game.getBoard());
	}
	
	/**
	 * Casos de uso
	 * 5- Matriz con 2 valores por fila (en 0 y 1)
	 *
	 */
	@Test
	public void twoValuesForRowInColumn0And1() {
	//		public static int[][] SEMIFULL22 = {{2,2,0},
	//											{2,2,0},
	//											{2,2,0}};
		Game2048 game = new Game2048(ForTesting.SEMIFULL22);
		game.compactRight();
		assertArrayEquals(ForTesting.SEMIFULL2_RIGHTCOMPACTED, game.getBoard());
	}
	
	/**
	 * Casos de uso
	 * 6- Matriz con 2 valores por fila (en 1 y 3)
	 *
	 */
	@Test
	public void twoValuesForRowInColumn1And4() {
	//		public static int[][] SEMIFULL23 = {{2,0,2},
	//											{2,0,2},
	//											{2,0,2}};
		Game2048 game = new Game2048(ForTesting.SEMIFULL23);
		game.compactRight();
		assertArrayEquals(ForTesting.SEMIFULL2_RIGHTCOMPACTED, game.getBoard());
	}
	
	/**
	 * Casos de uso
	 * 7- Matriz con 3 valores por fila 
	 *
	 */
	@Test
	public void threeValuesForRow() {
	//		public static int[][] FULL = {{2,2,2},
	//		  							  {2,2,2},
	//		  							  {2,2,2}};
		Game2048 game = new Game2048(ForTesting.FULL);
		game.compactRight();
		assertArrayEquals(ForTesting.FULL, game.getBoard());
	}	
}

