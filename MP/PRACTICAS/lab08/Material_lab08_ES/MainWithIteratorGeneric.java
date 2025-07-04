/**
 * 
 */
package uo.mp.util.collections.main;

import java.util.Iterator;

import uo.mp.util.collections.List;
import uo.mp.util.collections.impl.ArrayList;
import uo.mp.util.collections.impl.LinkedList;

/**
 * @author 
 *
 */
public class MainWithIteratorGeneric {
	public static void main(String[] args) {
		new MainWithIteratorGeneric().run();
	}

	/*
	 * Uso de las operaciones del iterador para una LinkedList y una ArrayList
	 *   recorrido con un iterador 
	 *   borrado de elementos con un iterador 
	 *   recorrido con un bucle foreach 
	 * 
	 */
	void run() {
		List<String> list = new LinkedList<String>();
		list.add("Uno");
		list.add("dos");
		list.add("tres");
		
		System.out.println("Recorrido con iterador.....con LinkedList");
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println((String) it.next());
		}
		
		// borramos los dos primeros elementos
//		it = list.iterator();
//		int i=0;
//		while (it.hasNext() && i<2) {
//			it.next();		
//			it.remove();
//			i++;			
//		}
		
		
		
		System.out.println("Recorrido con forEach.....con LinkedList");
		for(Object element: list) {
			System.out.println((String)element);
		}
		
		list = new ArrayList<String>();
		list.add("Uno");
		list.add("dos");
		list.add("tres");
		
		
		System.out.println("Recorrido con iterador.....con ArrayList");
		it = list.iterator();
		while (it.hasNext()) {
			System.out.println( it.next());
		}
		

		// borramos los dos primeros elementos
//		it = list.iterator();
//		int i=0;
//		while (it.hasNext() && i<2) {
//			it.next();		
//			it.remove();
//			i++;			
//		}
		
		System.out.println("Recorrido con forEach.....con ArrayList");
		for(Object element: list) {
			System.out.println(element);
		}
		
	}
}
