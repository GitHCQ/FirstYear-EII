/**
 * 
 */
package uo.mp.util.collections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
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
class AddInPositionTest3 {

	/**
	 * @throws java.lang.Exception
	 */
	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(new ArrayList()),
		      Arguments.of(new LinkedList())
		  );
		}

	@ParameterizedTest
	@MethodSource("createLists")
	public void addNonEmptyListAddAtIntermidiatePosition(List list) {
		list.add(0, "with");
		list.add(1, "JUnit");
		list.add(2, "framework");
		list.add(3, "framework2");
		int lsize = list.size();

		list.add(1, "testing");

		assertTrue(list.size() == lsize+1);
		assertTrue(list.get(1).equals("testing"));
		assertTrue(list.toString().equals("[with,testing,JUnit,framework,framework2]"));
	}
}
