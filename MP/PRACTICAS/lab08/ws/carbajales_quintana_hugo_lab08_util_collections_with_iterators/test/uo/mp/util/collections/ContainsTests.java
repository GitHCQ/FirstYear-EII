package uo.mp.util.collections;

import static org.junit.Assert.assertFalse;
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
 * 	1 Una lista vacía no contiene un elemento cualquiera
 * 	2 Una lista con varios elementos no contiene al elemento cualquiera 
 * 	3 Una lista con un elemento contiene al elemento
 * 	4 Una lista con varios elemento contiene al elemento
 * 	5 Una lista vacía no contienen null
 * 	6 Una lista con elementos no contiene null
 */
public class ContainsTests {
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
	public void emptyList(List list) {
		fail();
	}

	/**
	 * GIVEN: a list with some elements
	 * WHEN:  try to find a non existent element
	 * THEN: the method contains() return false
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void notInList(List list) {
		list.add(0, "testing");
		list.add(1, "with");
		list.add(2, "JUnit");
		list.add(3, "framework");
		
		assertFalse(list.contains("word"));
	}
	
	
	/**
	 * GIVEN: list with 1 element
	 * WHEN:  contains() is invoked
	 * THEN:  return true
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void onlyElementInList(List list) {
		
		list.add("testing");
		
		assertTrue(list.contains("testing"));
		
	}
	@ParameterizedTest@MethodSource("createLists")
	public void isInList(List list) {
		
		String s="with";
		list.add(0, s);
		list.add(1, "JUnit");
		list.add(2, "framework");
		list.add(3, "framework2");
		
		assertTrue(list.contains(s));
	}
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void emptyListDoesNotContainNull(List list) {

		fail();
	}
	
	/**
	 * GIVEN: una lista con elementos
	 * WHEN:  llmando a contains con null
	 * THEN:  devuelve false
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void nullNotInList(List list) {
		try {
			list.contains(null);
		} catch(IllegalArgumentException e) {
			//Añadir el mensaje que da la excepcion
		}
	}
}
