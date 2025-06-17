package uo.mp.lab02.game.model;

import static org.junit.Assert.*;

import org.junit.Test;
import uo.mp.lab02.game.model.util.ForTesting;

public class Game2048MoveUpTest {
	// Escenarios:
				// caso 1: Matriz con valores que se puedan sumar solo en la primera columna
				// caso 2: Matriz con valores que se puedan sumar solo en la segunda columna
			    // caso 3: Matriz con valores que se puedan sumar solo en la tercera columna
		        // caso 4: Matriz con valores que se puedan sumar en ninguna columna
		        // caso 5: Matriz llena
		        // caso 6: Matriz vacia.
				@Test
				public void SumOnlyFirstColumn() {
					Game2048 game = new Game2048(ForTesting.ONLYFISTCOLUMN); //{{2,2,0},{0,0,0},{0,0,0}}
					int[][] nueva = {{4, 0, 0}, {0, 0, 0}, {0, 0, 0}};
					game.moveUp();
					assertArrayEquals(nueva, game.getBoard());
				}
				@Test
				public void SumOnlySecondColumn() {
					Game2048 game = new Game2048(ForTesting.ONLYSECONDDCOLUMN); //{{2,2,0},{0,0,0},{0,0,0}}
					int[][] nueva = {{0, 4, 0}, {0, 0, 0}, {0, 0, 0}};
					game.moveUp();
					assertArrayEquals(nueva, game.getBoard());
				}
				@Test
				public void SumOnlyThirdColumn() {
					Game2048 game = new Game2048(ForTesting.ONLYTHIRDCOLUMN); //{{0,0,0},{2,2,0},{0,0,0}}
					int[][] nueva = {{0, 0, 4}, {0, 0, 0}, {0, 0, 0}};
					game.moveUp();
					assertArrayEquals(nueva, game.getBoard());
				}
				@Test
				public void NoSumColumns() {
					Game2048 game = new Game2048(ForTesting.SEMIFULL43); //{{2,4,8},{4,8,16},{0,0,0}};
					game.moveUp();
					assertArrayEquals(ForTesting.SEMIFULL43, game.getBoard());
				}
				@Test
				public void NoSumBoardFull() {
					Game2048 game = new Game2048(ForTesting.FULL); //{{2,4,8},{4,8,16},{8,16,32}};
					game.moveUp();
					assertArrayEquals(ForTesting.FULL, game.getBoard());
				}
				@Test
				public void NoSumBoardEmpty() {
					Game2048 game = new Game2048(ForTesting.EMPTY); //{{0,0,0},{0,0,0},{0,0,0}}
					game.moveUp();
					assertArrayEquals(ForTesting.EMPTY, game.getBoard());
				}
	}