package uo.mp.lab01.game.model;

import static org.junit.Assert.assertArrayEquals;


import org.junit.Test;

import uo.mp.lab01.game.model.util.ForTesting;

public class Game2048CompactDownTest {

	/*
	 * Casos de uso
	 * 1. Matriz con un valor por columna en la fila 0
	 * 2- Matriz con un valor por columna en la fila 1
	 * 3- Matriz con un valor por columna en fila 2
	 * 
	 * 4- Matriz con 2 valores por columna (en 1 y 2)
	 * 5- Matriz con 2 valores por columna (en 0 y 1)
	 * 6- Matriz con 2 valores por columna (en 1 y 3)
	 * 
	 * 7- Matriz con 3 valores por columna 
	 * 
	 */
	
	/**
	 * Casos de uso
	 * 1. Matriz con un valor por columna en la fila 0
	 */
	@Test
	public void OneValueForRowInColumn0() {
		//		public static int[][] SEMIFULL33 = {{2,2,2},
		//                							{0,0,0},
		//                							{0,0,0}};
		Game2048 game = new Game2048(ForTesting.SEMIFULL33);
		game.compactDown();
		assertArrayEquals(ForTesting.SEMIFULL3_DOWNCOMPACTED, game.getBoard());
	}
	
	/**
	 * Casos de uso
	 * 2- Matriz con un valor por columna en columna 1
	 */
	@Test
	public void oneValueForRowInColumn1() {
		//		public static int[][] SEMIFULL32 = {{0,0,0},
		//											{2,2,2},
		//											{0,0,0}};
		Game2048 game = new Game2048(ForTesting.SEMIFULL32);
		game.compactDown();
		assertArrayEquals(ForTesting.SEMIFULL3_DOWNCOMPACTED, game.getBoard());
	}
	
	/**
	 * Casos de uso
	 * 3- Matriz con un valor por columna en la fila 2
	 */
	@Test
	public void oneValueForRowInColumn2() {
		//		public static int[][] SEMIFULL31 = {{0,0,0},
		//											{0,0,0},
		//											{2,2,2}};
		Game2048 game = new Game2048(ForTesting.SEMIFULL31);
		game.compactDown();
		assertArrayEquals(ForTesting.SEMIFULL3_DOWNCOMPACTED, game.getBoard());
	}
	
	/**
	 * Casos de uso
	 * 4- Matriz con 2 valores por columna (en 1 y 2)
	 *
	 */
	@Test
	public void twoValuesForRowInColumn1And2() {
	//		public static int[][] SEMIFULL41 = {{0,0,0},
	//											{2,2,2},
	//											{2,2,2}};
		Game2048 game = new Game2048(ForTesting.SEMIFULL41);
		game.compactDown();
		assertArrayEquals(ForTesting.SEMIFULL4_DOWNCOMPACTED, game.getBoard());
	}
	
	/**
	 * Casos de uso
	 * 5- Matriz con 2 valores por fila (en 0 y 1)
	 *
	 */
	@Test
	public void twoValuesForRowInColumn0And1() {
	//		public static int[][] SEMIFULL43 = {{2,2,2},
	//											{2,2,2},
	//											{0,0,0}};
		Game2048 game = new Game2048(ForTesting.SEMIFULL43);
		game.compactDown();
		assertArrayEquals(ForTesting.SEMIFULL4_DOWNCOMPACTED, game.getBoard());
	}
	
	/**
	 * Casos de uso
	 * 6- Matriz con 2 valores por fila (en 0 y 2)
	 *
	 */
	@Test
	public void twoValuesForRowInColumn1And4() {
	//		public static int[][] SEMIFULL42 = {{2,2,2},
	//											{0,0,0},
	//											{2,2,2}};
		Game2048 game = new Game2048(ForTesting.SEMIFULL42);
		game.compactDown();
		assertArrayEquals(ForTesting.SEMIFULL4_DOWNCOMPACTED, game.getBoard());
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
		game.compactDown();
		assertArrayEquals(ForTesting.FULL, game.getBoard());
	}	
}
