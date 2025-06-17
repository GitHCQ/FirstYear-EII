package uo.mp.newsstand.domain;

import uo.mp.util.check.ArgumentChecks;

public class Order {
	private String name;
	private int quantity;
	
	public Order(String name, int quantity){
		ArgumentChecks.isNotBlank(name);
		ArgumentChecks.isNotNull(name);
		this.name=name;
		this.quantity=quantity;

	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public String toString(){
		return "Order: " + getName() + "\t" + getQuantity();
	}
	
	public String serialize(){
		return  getName() + "\t" + getQuantity();
	}
	
}
