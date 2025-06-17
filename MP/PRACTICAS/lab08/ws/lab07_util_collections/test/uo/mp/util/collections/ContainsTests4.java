/**
 * 
 */
package uo.mp.util.collections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import uo.mp.util.collections.impl.ArrayList;
import uo.mp.util.collections.impl.LinkedList;

/**
 * @author UO300619
 *
 */
class ContainsTests4 {
	
	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(new ArrayList()),
		      Arguments.of(new LinkedList())
		  );
		}
	
	public void isInList(List list) {
		
		String s="with";
		list.add(0, s);
		list.add(1, "JUnit");
		list.add(2, "framework");
		list.add(3, "framework2");
		
		assertTrue(list.contains(s));
	}

	

}
