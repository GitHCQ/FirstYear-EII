package uo.mp.lab01.game.model;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import uo.mp.lab01.game.model.util.ForTesting;

public class Game2048NextTest {
	/*
	 * Casos de uso
	 * 1. Matriz vacía y se añade un 2.
	 * 2- Matriz semillena y no se añade un 2.
	 * 3- Matriz llena y no se añade un 2. 
	 */
	//Metodo auxiliar que verifica que se ha colocado un 2
	/**
	 * Caso 1.Se añade un 2 en una posicion aleatoria ya que la matriz está vacia.
	 */
	 @Test
	 public void boardEmptyAdd2() {
		 Game2048 game=new Game2048(ForTesting.EMPTY);
		 int suma_inicial=ForTesting.getSum(game.getBoard());
		 assertEquals(0,suma_inicial);
		 game.next();
		 assertEquals(2,ForTesting.getSum(game.getBoard()));
		 
		 
      }
	  /**
	  * Caso 2.Se añade un 2 en una posicion aleatoria ya que la matriz está semillena.
	  */
	 @Test
	 public void boardSemiFullAdd2() {
	     Game2048 game = new Game2048(ForTesting.SEMIFULL12);
	     int suma_inicial=ForTesting.getSum(ForTesting.SEMIFULL12);
		 game.next();
		 assertEquals(suma_inicial+2,ForTesting.getSum(game.getBoard()));
	     
	 }
	 /**
	 * Caso 3.No se añade un 2 en una posicion aleatoria ya que la matriz está llena.
	 */
	 @Test
	 public void boardFullNoAdd2() {
	     Game2048 game = new Game2048(ForTesting.FULL);
	     int suma_de_las_posiciones=ForTesting.getSum(game.getBoard());
		 game.next();
		 assertEquals(suma_de_las_posiciones,ForTesting.getSum(game.getBoard()));
	     
	 }
}
