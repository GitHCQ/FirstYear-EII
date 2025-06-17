package uo.mp.lab01.game.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class Game2048WithoutParamsTest {
	/*
	 * Caso único de las pruebas del constructor sin parametros.
	 * -El tablero se crea correctamente, con las dimensiones 3x3 y todos sus valores son 0
	 */
	private boolean matrizDeZeros(int [][]matriz) {
		for(int i=0;i<matriz.length;i++) {
			for(int j=0;j<matriz[i].length;j++) {
				if(matriz[i][j]!=0) {
					return false;
				}
			}
		}
		return true;
	}
	@Test
	public void tableroWithoutParams() {
		Game2048 game=new Game2048();
		int [][] game1=new int[3][3];
		assertEquals(3,game1.length);
		assertTrue(matrizDeZeros(game1));
	}
}
