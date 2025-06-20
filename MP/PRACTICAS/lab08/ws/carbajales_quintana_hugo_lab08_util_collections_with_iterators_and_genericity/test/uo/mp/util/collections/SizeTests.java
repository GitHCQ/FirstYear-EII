package uo.mp.util.collections;

import static org.junit.Assert.assertEquals;
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
 *  1 Una lista vacía devueve 0
 * 	2 Una lista no vacía, devuelve el número de elementos correcto
 */
public class SizeTests {
	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(new ArrayList<Object>()),
		      Arguments.of(new LinkedList<Object>())
		  );
		}

	/**
	 * GIVEN: an empty list
	 * WHEN:    size() is invoked
	 * THEN: it returns 0
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void emptyList(List<?> list) {
		assertEquals(list.size(),0);
	}
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void nonEmptyList(List<?> list) {
		fail();
	}

}
