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
class EqualsTests8 {

	private static Stream<Arguments> create2ListsSameType() {
	    return Stream.of(
	    		Arguments.of(new ArrayList(), new ArrayList()),
	    		Arguments.of(new LinkedList(), new LinkedList())
	    );
	}
	
	
	@ParameterizedTest@MethodSource("create2ListsDifferentType")
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	public void arrayListLinkedListDifferentItems(List list1, List list2) {
		String s="with";
		list1.add(0, s);
		list2.add(1,s);
		
		assertFalse(list1.equals(list2));

	}
	
	
}
