/**
 * 
 */
package uo.mp.newsstand.service.comparator;

import java.util.Comparator;

import uo.mp.newsstand.domain.Order;

/**
 * @author usuario
 *
 */
public class byQuantityAndNameComparator implements Comparator<Order>{

	@Override
	public int compare(Order o1, Order o2) {
		int dif=o1.getQuantity()-o2.getQuantity();//Diferencia entre sus cantidades
		if(dif==0) {
			return o1.getName().compareTo(o2.getName());
		}else {
			return dif;
		}
		
	}

}
