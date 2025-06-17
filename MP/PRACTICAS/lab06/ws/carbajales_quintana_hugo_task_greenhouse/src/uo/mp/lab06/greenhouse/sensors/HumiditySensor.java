package uo.mp.lab06.greenhouse.sensors;

import java.util.Random;

import uo.mp.lab06.greenhouse.controllers.devicescanner.Checkable;

public class HumiditySensor implements Checkable{
	private int id;
	public HumiditySensor(int id) {
		this.id=id;
	}

	/**
	 * Los sensores de humedad devuelven un valor aleatorio entre 0% y 100%
	 * @return valor random entre 0 y 100
	 */
	public double getHumidity() {
		Random r=new Random();
		return r.nextDouble(96)+5;
	}
	@Override 
	public String toString() {
		return "[HumiditySensor] "+id;
	}
	@Override
	public boolean check() {
		return new Random().nextDouble()>0.005;
	}
	
	

}
