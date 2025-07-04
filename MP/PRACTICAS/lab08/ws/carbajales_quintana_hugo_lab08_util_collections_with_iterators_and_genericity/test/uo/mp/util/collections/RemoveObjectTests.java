package uo.mp.util.collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import uo.mp.util.collections.impl.ArrayList;
import uo.mp.util.collections.impl.LinkedList;

/*
 * SCENARIOS
 * 	1 Eliminar un object en una lista vacía devuelve false y deja la lista como estaba
 * 	2 Eliminar un object existente en una lista con un elemento, devuelve true y la lista queda vacía
 *  3 Eliminar un object existente en una lista con varios elementos, devuelve true y el elemento es borrado
 *  4 Eliminar un object no existente en una lista con elementos, devuelve false y la lista no cambia
 *  5 Intentar realizar remove con null lanza IllegalArgumentException
 *  
 */	
public class RemoveObjectTests {

	public static Stream<Arguments> createLists() {
		return Stream.of(Arguments.of(new ArrayList<Object>()), Arguments.of(new LinkedList<Object>()));
	}

	/**
	 * GIVEN: WHEN: THEN:
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void emptyList(List<?> list) {
		fail();
	}

	/**
	 * GIVEN: Una lista con un elemento
	 *  WHEN: Se llama a removeObjec con ese objeto
	 *  THEN: Deja la lista vacía
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void singleItemList(List<String> list) {
		String s = "delete";
		list.add(0,s);
		list.remove(s);
		assertFalse(list.contains(s));
		assertTrue(list.size()==0);
	}
	/**
	 * GIVEN: WHEN: THEN:
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void notInList(List<?> list) {
		fail();
	}

	/**
	 * GIVEN: WHEN: THEN:
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void inListFirst(List<?> list) {
		fail();

	}

	/**
	 * GIVEN: WHEN: THEN:
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void inListLast(List<?> list) {
		fail();

	}

	/**
	 * GIVEN: WHEN: THEN:
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void inListOther(List<?> list) {
		fail();

	}

	/**
	 * GIVEN: WHEN: THEN:
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void inListRepeated(List<?> list) {
		fail();
	}

	/**
	 * GIVEN: WHEN: THEN:
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void nullObject(List<?> list) {
		fail();
	}
}
