package uo.mp.lab01.game.model;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.lab01.game.model.Game2048;


public class Game2048WithIntParamTest {
	/*
	 * Casos del constructor con un parametro:
	 * -Caso1:La dimension introducida es 2
	 * -Caso2:La dimension introducida es 5
	 * -Caso3:La dimension introducida es menor que 2
	 * -Caso4:La dimension introducida mayor que 5
	 * -Caso 5:La dimension introducida se encuentra entre 2 y 5.
	 */
	//Metodo que verifica que todas los elementos sean cero.
	private boolean allZero(int [][] matrix) {
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if(matrix[i][j]!=0) {
					return false;
				}
			}
		}
		return true;
		
	}
	/**
	 * Caso1:Dimension es 2
	 */
	@Test
	public void size2() {
		Game2048 game=new Game2048(2);
		assertEquals(2,game.getBoard().length);
		assertEquals(2, game.getBoard()[0].length);
		assertTrue(allZero(game.getBoard()));
	}
	/**
	 * Caso2:Dimension es 5
	 */
	@Test
	public void size5() {
		Game2048 game=new Game2048(5);
		assertEquals(5,game.getBoard().length);
		assertEquals(5, game.getBoard()[0].length);
		assertTrue(allZero(game.getBoard()));
	}
	/**
	 * Caso3:Dimension es 1
	 */
	@Test
	public void size1() {
		Game2048 game=new Game2048(1);
		assertEquals(3,game.getBoard().length);
		assertEquals(3, game.getBoard()[0].length);
		assertTrue(allZero(game.getBoard()));
	}
	/**
	 * Caso4:Dimension es 6
	 */
	@Test
	public void size6() {
		Game2048 game=new Game2048(6);
		assertEquals(3,game.getBoard().length);
		assertEquals(3, game.getBoard()[0].length);
		assertTrue(allZero(game.getBoard()));
	}
	/**
	 * Caso4:Dimension es 4
	 */
	@Test
	public void size4() {
		Game2048 game=new Game2048(4);
		assertEquals(4,game.getBoard().length);
		assertEquals(4, game.getBoard()[0].length);
		assertTrue(allZero(game.getBoard()));
	}
	
}
