package uo.mp.util.collections;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import uo.mp.util.collections.impl.ArrayList;
import uo.mp.util.collections.impl.LinkedList;

/*
 * ESCENARIOS
 * 	1 Remove de la posición 0 de una lista con un elemento devuelve el elemento eliminado y la lista queda vacía
 *  2 Remove de la posición 0 de una lista no vacía devuelve el elemento eliminado, quita el elemento de la lista y  mueve el resto de elementos una posición a la izquierda
 *  3 Remove de una posición existente, devuelve el elemento borrado, se quita el elemento de la lista y mueve los elementos de la derecha una posición a la izquierda
 *  4 Remove de la última posición, devuelve el elemento borrado y quita el lemento de la lista
 *  5 Intentar realizar remove en la posición -1 lanza IndexOutOfBoundsException
 *  6 Intentar realizar remove en la posición 0 de una lista vacía, lanza IndexOutOfBoundsException
 *  7 Intentar realizar remove en la posición size() de una lista vacía, lanza IndexOutOfBoundsException
 *  8 Intentar realizar remove en la posición size() de una lista no vacía, lanza IndexOutOfBoundsException
 */
public class RemoveFromPositionTests {
	
	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(new ArrayList()),
		      Arguments.of(new LinkedList())
		  );
		}



	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void delOnlyItem(List list) {
		fail();
	}


	/**
	 * GIVEN: A non-empty list of objects
	 * WHEN:  Removing the first object
	 * THEN: Returns the removed object and the rest move to the left
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void delFirst(List list) {
		list.add("B");
		list.add("A");
		list.add("R");
		String prev_sec= "A";
		String prev_third= "R";
		assertEquals(list.get(0), list.remove(0));
		//TRAS ELIMINARLO
		assertEquals(prev_sec, list.get(0));
		assertEquals(prev_third, list.get(1));
	}
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void delLast(List list) {
		fail();
	}

	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void delMiddle(List list) {
		list.add(0, "with");
		list.add(1, "JUnit");
		list.add(2, "framework");
		assertEquals(3,list.size());
		
		assertEquals(list.remove(1),"JUnit");
		assertEquals(2,list.size());
		assertFalse(list.contains("JUnit"));
		assertTrue(list.toString().equals("[with, framework]"));
		

	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void emptyList(List list) {
		fail();
	}
	

	/**
	 * GIVEN: An empty List
	 * WHEN:  try to invoke remove with position 0
	 * THEN: throws indexOutOfBoundsException
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void upperBound(List list) {
		List list1 = list;
		try{
			list.remove(0);
			fail();
		}
		catch(IndexOutOfBoundsException e) {
			assertTrue(list.equals(list1));
		}
	}
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void lowerBound(List list) {
	    if (!list.isEmpty()) { // Verifica si la lista no está vacía
	        try {
	            @SuppressWarnings("unused")
				Object element = list.get(0); // Intenta acceder a la posición 0
	        } catch (IndexOutOfBoundsException e) {
	            fail("Se lanzó IndexOutOfBoundsException al intentar acceder a la posición 0");
	        }
	    }
	}

}
