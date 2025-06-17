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
class GetTests4 {

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
	public void emptyMinusOne(List list) {
		try {
			list.add(0, "with");
			list.add(1, "JUnit");
			list.add(2, "framework");
			list.get(list.size());
			fail("Deberia de haber fallado");
		}catch(IndexOutOfBoundsException e) {
			assertEquals("Index out of range: " + list.size(),e.getMessage());
		}
	}


}
