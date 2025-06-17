package uo.mp.util.collections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import uo.mp.util.collections.impl.ArrayList;
import uo.mp.util.collections.impl.LinkedList;

class RemoveFromPositionTests7 {

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
	public void upperBound(List list) {
		try {
			list.add(0, "with");
			list.add(1, "JUnit");
			list.add(2, "framework");
			list.remove(list.size());
			fail("Deberia de haber fallado");
		}catch(IndexOutOfBoundsException e) {
			assertEquals("Index out of range: " + list.size(),e.getMessage());
		}
	}

}
