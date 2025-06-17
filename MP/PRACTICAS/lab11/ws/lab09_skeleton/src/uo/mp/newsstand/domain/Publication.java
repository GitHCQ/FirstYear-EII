package uo.mp.newsstand.domain;

import java.util.Objects;

import uo.mp.newsstand.service.NewstandException;
import uo.mp.util.check.ArgumentChecks;

public abstract class Publication implements Comparable<Publication>{
	private String name;
	private int instock;
	private int sales;
	protected static final int MIN_COPIES=10;

	protected Publication(String name, int sales, int stock) {
		setName(name);
		setSales(sales);
		setStock(stock);
	}

	private void setStock(int stock) {
		ArgumentChecks.isTrue( stock > 0, "Trying to create a new Publication: Illegal stock under zero" );
		
		this.instock = stock;
	}

	private void setSales(int sales) {
		ArgumentChecks.isTrue( sales > 0, "Trying to create a new Publication: Illegal sales under zero" );
		
		this.sales = sales;
	}

	private void setName(String name) {
		ArgumentChecks.isNotNull( name, "Trying to create a new Publication: Illegal null name" );
		ArgumentChecks.isNotBlank( name, "Trying to create a new Publication: Illegal blank name" );
		this.name = name;
	}

	public String getName() {
		return name;
	}

	protected int getStock() {
		return instock;
	}

	protected int getSales() {
		return sales;
	}

	@Override
	public String toString() {
		return getName() + "\t" + getStock() + "\t" + getSales();
	}

	@Override
	public int hashCode() {
		return Objects.hash(instock, name, sales);
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publication other = (Publication) obj;
		return instock == other.instock && Objects.equals(name, other.name) && sales == other.sales;
	}

	public abstract Order generateOrders() throws NewstandException;
	public abstract String serialize();

	@Override
	public int compareTo(Publication o) {
		return this.getName().compareTo(o.getName());
	}
	
}
