package uo.mp.util.collections;

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
 * 	1 Set en la posición 0 de una lista con varios elementos, cambia el valor de la posición n y devuelve el valor anterior de esa posición
 * 	2 Set en la posición n de una lista con un elemento cambia el valor y devuelve el valor anterior de esa posición 
 * 	3 Intentar realizar set en la posición -1 de una lista vacía, lanza IndexOutOfBoundsException
 * 	4 Intentar realizar set en la posición size() de una lista vacía, lanza IndexOutOfBoundsException
 * 	5 Intentar realizar set en la posición -1 de una lista con elementos, lanza IndexOutOfBoundsException
 * 	6 Intentar realizar set en la posición size() de una lista con elementos, lanza  IndexOutOfBoundsException
 */
public class SetTests {
	
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
	public void setFirst(List list) {
		fail();
	}
	
	/**
	 * GIVEN: Una lista con algun elemento
	 * WHEN:   Se llama a set en una posicion 
	 * THEN: Devuelve el elemento que habia almacenado y lo cambia
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void setFinal(List list) {
		String s = "test";
		list.add(s);
		Object ret = list.set(0, "change");
		assertTrue(list.get(0).equals("change"));
		assertEquals(s,ret);
	}
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void setMiddle(List list) {
		fail();

	}
	
	/**
	 * GIVEN: lista vacía 
	 * WHEN:  llama al set con size() como parámetro
	 * THEN:  está fuera del límite y salta excepción
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void empty(List list) {
		try {
			String s = "test";
			list.set(list.size(), s);
		}
		catch (IndexOutOfBoundsException e) {
			// escribir la excepción
		}
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void upper(List list) {
		fail();

		
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void lower(List list) {
		fail();

	}



}
