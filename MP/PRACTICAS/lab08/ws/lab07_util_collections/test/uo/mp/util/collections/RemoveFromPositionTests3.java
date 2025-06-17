/**
 * 
 */
package uo.mp.util.collections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import uo.mp.util.collections.impl.ArrayList;
import uo.mp.util.collections.impl.LinkedList;

/**
 * @author UO300619
 *
 */
class RemoveFromPositionTests3 {

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
	public void delMiddle(List list) {
		list.add(0, "with");
		list.add(1, "JUnit");
		list.add(2, "framework");
		assertEquals(3,list.size());
		
		assertEquals(list.remove(1),"Junit");
		assertEquals(2,list.size());
		assertFalse(list.contains("Junit"));
		assertTrue(list.toString().equals("[with,framework]"));
		

	}

}
