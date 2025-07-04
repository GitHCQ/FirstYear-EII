package uo.mp.util.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import uo.mp.util.collections.impl.ArrayList;
import uo.mp.util.collections.impl.LinkedList;

/*
 * ESCENARIOS
 * 	1 El index de un elemento que no existe es -1
 * 	2 El index de null es -1
 *  3 El index de un elemento localizado en la primera posición de la lista es 0
 *  4 El index de un elemento localizado en la última posición de la lista es size() -1
 *  5 El index de un elemento colocado en medio de la lista es la posición que tiene
 *  6 En una lista con elementos repetidos, el indexOf de un elemento devuelve la posición de la primera aparición * 
 */
public class IndexOfTests {
	
	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(new ArrayList<Object>()),
		      Arguments.of(new LinkedList<Object>())
		  );
		}

	/**
	 * GIVEN: a non existent element in an array
	 * WHEN:    try to find the element's index in the array
	 * THEN: returns -1 as there was non element in the array
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void nullElem(List<String> list) {
		list.add("algo");
		list.add("otro");
		
		int index=-1;
		assertEquals(index, list.indexOf("Error"));
		
	}
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void emptyList(List<?> list) {
		fail();
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void firstInList(List<String> list) {
		String s="with";
		list.add(0, s);
		list.add(1, "JUnit");
		
		assertEquals(0,list.indexOf(s));
	}

	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void lastInList(List<?> list) {
		fail();
	}
	
	/**
	 * GIVEN: Una lista con varios elementos
	 * WHEN:   Se llama a indexOf con un elemento en medio
	 * THEN:  Devuelve su posicion
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void midInList(List<String> list) {
		list.add("1");
		list.add("2");
		String s = "3";
		list.add(s);
		list.add("4");
		assertEquals(list.indexOf(s),2);
	}


}
