package uo.mp.util.collections;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import uo.mp.util.collections.impl.ArrayList;
import uo.mp.util.collections.impl.LinkedList;

public class IteratorTests {

	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(new ArrayList()),
		      Arguments.of(new LinkedList())
		  );
		}
	
	
	/**
	 * GIVEN: an empty list 
	 * THEN: hasNext devuelve false
	 */
	
	@ParameterizedTest
	@MethodSource("createLists")
	public void emptyListWhithHasNext(List list) {
		Iterator<Object> it = list.iterator();
		assertFalse(it.hasNext());		
	}
	
	
	/**
	 * GIVEN: an empty list 
	 * THEN: next lanza NoSuchElementExeption
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void emptyListWhithNext(List list) {
		Iterator<Object> it = list.iterator();
		try {
			it.next();
		} catch (NoSuchElementException e ) {
			assertTrue(true);
		}
	}
	

	/**
	 * GIVEN: non empty list 
	 * THEN: next devuelve los valores
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void someElementsList(List list) {
		list.add("A");
		list.add("B");
		list.add("C");
		
		Iterator<Object> it = list.iterator();
		
		assertTrue(it.hasNext());
		assertEquals("A", it.next());
		assertEquals("B", it.next());
		assertEquals("C", it.next());
		
		try {
			it.next();
		} catch (NoSuchElementException e ) {
			assertTrue(true);
		}
	}
	
	/**
	 * GIVEN: non empty list
	 * WHEN  first element is removed 
	 * THEN: the elemente is removed
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void firstElementremoved(List list) {
		list.add("A");
		list.add("B");
		list.add("C");
		
		Iterator<Object> it = list.iterator();
		
		it.next();
		it.remove();
		assertEquals(2, list.size());
		assertEquals("B", list.get(0));
		assertEquals("C", list.get(1));			
	}
	
	/**
	 * GIVEN: non empty list
	 * WHEN  second element is removed 
	 * THEN: the elemente is removed
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void secondElementremoved(List list) {
		list.add("A");
		list.add("B");
		list.add("C");
		
		Iterator<Object> it = list.iterator();
		
		it.next();
		it.next();
		it.remove();
		assertEquals(2, list.size());
		assertEquals("A", list.get(0));
		assertEquals("C", list.get(1));			
	}
	
	/**
	 * GIVEN: non empty list
	 * WHEN  last element is removed 
	 * THEN: the elemente is removed
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void lastElementremoved(List list) {
		list.add("A");
		list.add("B");
		list.add("C");
		
		Iterator<Object> it = list.iterator();
		
		it.next();
		it.next();
		it.next();
		it.remove();
		assertEquals(2, list.size());
		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));			
	}
	
	/**
	 * GIVEN: non empty list
	 * WHEN  first removed without apply next 
	 * THEN: an IllegalStateException is thrown
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void firstremovedWithoutNext(List list) {
		list.add("A");
		list.add("B");
		list.add("C");
		
		Iterator<Object> it = list.iterator();
		
		try {
			it.remove();
		} catch (IllegalStateException e) {
			assertEquals(3, list.size());
			assertEquals("A", list.get(0));
			assertEquals("B", list.get(1));	
			assertEquals("C", list.get(2));	
		}
				
	}
	
	/**
	 * GIVEN: non empty list
	 * WHEN   removed two ice 
	 * THEN: an IllegalStateException is thrown
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void removeTwoIce(List list) {
		list.add("A");
		list.add("B");
		list.add("C");
		
		Iterator<Object> it = list.iterator();
		it.next();
		it.next();
		it.remove();
		try {
			it.remove();
		} catch (IllegalStateException e) {
			assertEquals(2, list.size());
			assertEquals("A", list.get(0));
			assertEquals("C", list.get(1));	
			
		}
				
	}
		
}
