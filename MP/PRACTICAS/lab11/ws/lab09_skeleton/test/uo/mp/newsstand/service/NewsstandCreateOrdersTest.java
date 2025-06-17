package uo.mp.newsstand.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.newsstand.domain.Magazine;
import uo.mp.newsstand.domain.Newspaper;
import uo.mp.newsstand.domain.Order;
import uo.mp.newsstand.domain.Magazine.Frequency;

public class NewsstandCreateOrdersTest {

	Newsstand newsstand;
	Newspaper news;
	Magazine magazine;
	

	@BeforeEach
	public void setUp() throws Exception {
		newsstand=new Newsstand();
	}
	
	/**
	 * GIVEN: A newspaper with enough copies in stock 
	 * WHEN: generate orders
	 * THEN: no new order is generated
	 * @throws NewstandException 
	 */
	@Test
	public void enoughCopiesNewspaperNoOrderTest() throws NewstandException {
		int stock=15;
		int sales=5;
		news=new Newspaper("La nueva",stock,sales);
		Newsstand newsstand=new Newsstand();
		newsstand.addPublication(news);
		
		newsstand.createOrders();
		List<Order>orders=newsstand.getOrders();
		assertEquals(0,orders.size());
	}

	/**
	 * GIVEN: A newspaper with copies in stock in the limit 
	 * WHEN: generate orders
	 * THEN: no new order is generated
	 */
	@Test
	public void copiesintheLimitNewspaperNoOrderTest() {
		fail();
	}
	
	/**
	 * GIVEN: A newspaper with no enough copies in stock 
	 * WHEN: generate orders
	 * THEN: new order is generated with name and 20
	 */
	@Test
	public void noEnoughCopiesNewspaperNoOrderTest() throws NewstandException{
		int stock=9;
		int sales=5;
		int expectedOrder=sales+2*stock;
		news=new Newspaper("La nueva",stock,sales);
		Newsstand newsstand=new Newsstand();
		newsstand.addPublication(news);
		
		newsstand.createOrders();
		List<Order>orders=newsstand.getOrders();
		
		assertEquals(1,orders.size());
		assertEquals(expectedOrder,orders.size()); 
			}

	/**
	 * GIVEN: A weekly magazine with enough copies in stock 
	 * WHEN: generate orders
	 * THEN: no new order is generated
	 */
	@Test
	public void enoughCopiesWeeklyMagazineNoOrderTest() {
		fail();
	}
	
	/**
	 * GIVEN: A weekly magazine with copies in stock in the limit 
	 * WHEN: generate orders
	 * THEN: no new order is generated
	 */
	@Test
	public void limitCopiesWeeklyMagazineNoOrderTest() {
		fail();
	}
	
	/**
	 * GIVEN: A weekly magazine with copies in stock under 5 
	 * WHEN: generate orders
	 * THEN: order is generated to order 20 copies 
	 */
	@Test
	public void weeklyMagazineCopiesUnder5Order20() {
		fail();
	}
	
	/**
	 * GIVEN: A weekly magazine with copies in stock equals 5
	 * WHEN: generate orders
	 * THEN: order is generated to order number of copies sold
	 */
	@Test
	public void weeklyMagazine5CopiesOrderSold() {
		fail();
	}
	
	
	
	/**
	 * GIVEN: A monthly magazine with enough copies in stock 
	 * WHEN: generate orders
	 * THEN: no new order is generated
	 */
	@Test
	public void enoughCopiesMonthlyMagazineNoOrderTest() {
		fail();
	}
	
	/**
	 * GIVEN: A monthly magazine with copies in stock in the limit (10)
	 * WHEN: generate orders
	 * THEN: no new order is generated
	 */
	@Test
	public void limitCopiesMonthlyMagazineNoOrderTest() {
		fail();
	}
	
	/**
	 * GIVEN: A monthly magazine with copies in stock under 5 
	 * WHEN: generate orders
	 * THEN: order is generated to order 20 copies 
	 */
	@Test
	public void monthlyMagazineCopiesUnder5Order20() {
		fail();
	}
	
	/**
	 * GIVEN: A monthly magazine with copies in stock equals 5
	 * WHEN: generate orders
	 * THEN: order is generated to order number of copies sold +
	 * 									  number of copies in stock
	 */
	@Test
	public void monthlyMagazine5CopiesOrderSoldPlusStock() {
		fail();
	}
	
}
