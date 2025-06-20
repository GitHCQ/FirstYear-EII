package uo.mp.newsstand.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import uo.mp.newsstand.service.NewstandException;
import uo.mp.util.check.ArgumentChecks;

public class Magazine extends Publication {

	private static final int MIN_COPIES = 10;
	public static int MIN_STOCK = 5;
	public static int MIN_ORDER = 20;

	public static enum Frequency {
		WEEKLY, MONTHLY, NOTSUNDAY, NOTAUGUST, BIMONTHLY, QUARTERLY;
		
		public static List<String> getNames(){
			List<String> result = new ArrayList<>();
			result.add("weekly");
			result.add("monthly");
			result.add("notsunday");
			result.add("notaugust");
			result.add("bimonthly");
			result.add("quarterly");
			return result;
		}
	}

	private Frequency frequency;

	public Magazine(String name, int stock, int sales, Frequency freq) {
		super(name, sales, stock);
		setFrequency(freq);
	}

	private void setFrequency(Frequency freq) {
		ArgumentChecks.isNotNull(freq, "Trying to create a new Magazine: Invalid null frequency");
		this.frequency = freq;
	}

	private Frequency getFrequency() {
		return frequency;
	}

	@Override
	public String toString() {
		return super.toString() + "\t" + getFrequency();
	}

	@Override
	public String serialize() {
		return "magazine" + "\t" + getName() + "\t" + getStock() + "\t" + getSales() + "\t" + getFrequency();
	}

	@Override
	public Order generateOrders() throws NewstandException {
		if(getStock()>=MIN_COPIES) {
			throw new NewstandException("No es necesario pedido para "+getName());
		}
		if (getStock() < MIN_STOCK) {
			return new Order(this.getName(), MIN_ORDER);
		} else {
			if (getFrequency().equals(Frequency.WEEKLY)) {
				return new Order(this.getName(), getSales());
			} else {
				return new Order(this.getName(), getSales() + getStock());
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(frequency);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Magazine other = (Magazine) obj;
		return frequency == other.frequency;
	}
	

}
