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
class EqualsTests12 {

	private static Stream<Arguments> create2ListsDifferentType() {
	    return Stream.of(
	    		Arguments.of(new ArrayList(), new LinkedList()),
	    		Arguments.of(new LinkedList(), new ArrayList())
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
		String a="With2";
		list1.add(0, s);
		list2.add(0,a);
		
		assertFalse(list1.equals(list2));

	}

}
