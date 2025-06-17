package uo.mp.newsstand.domain;

import uo.mp.newsstand.service.NewstandException;

public class Newspaper extends Publication {

	private static final int MIN_COPIES =10 ;


	public Newspaper(String name,  int stock, int sales) {
		super(name, sales, stock);
	}


	@Override
	public Order generateOrders() throws NewstandException {
	if(getStock()<MIN_COPIES){
		return new Order(getName(), getSales() + (getStock() * 2));
	}else {
		throw new NewstandException("No es necesario pedido para "+getName());
	}
}
	

	@Override
	public String serialize() {
		return "newspaper" 
				+ "\t" + getName() 
				+ "\t" + getStock() 
				+ "\t" + getSales(); 
	}
}
