package uo.mp.util.collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import uo.mp.util.collections.impl.ArrayList;
import uo.mp.util.collections.impl.LinkedList;

/*
 * ESCENARIOS
 * 	1 Una lista recien creada esta vacía
 *  2 Una lista queda vacía después de la operación clear
 *  3 Una lista con un elemento no está vacía
 *  4 Una lista con más de un elemento no esta vacía
 */
public class IsEmptyTests {
	
	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(new ArrayList<Object>()),
		      Arguments.of(new LinkedList<Object>())
		  );
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
	public void clearedList(List<?> list) {
		fail();
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void sizeOneList(List<?> list) {
		fail();
	}
	
	/**
	 * GIVEN: a list with more than one element
	 * WHEN:  isEmpty() is invoked   
	 * THEN: it returns false
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void severalItemsList(List<String> list) {
		list.add(0, "with");
		list.add(1, "JUnit");
		list.add(2, "framework");
		list.add(0, "testing");

		assertTrue(list.size() == 4);
		assertFalse(list.isEmpty());

	}
}
